package com.diagknowlogy.diagspace;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diagknowlogy.spring.model.Alert;
import com.diagknowlogy.spring.model.KPI;
import com.diagknowlogy.spring.model.MatchedProblem;
import com.diagknowlogy.spring.model.ProblemInfo;
import com.diagknowlogy.spring.model.ProblemStatus;
import com.diagknowlogy.spring.model.ProgressLevel;
import com.diagknowlogy.spring.model.SymptomGraphPoint;
import com.diagknowlogy.spring.model.Who;
import com.diagknowlogy.spring.model.Comments;

@Controller
public class DiagSpaceController {
	private static final Logger logger = LoggerFactory.getLogger(DiagSpaceController.class);
	
	@RequestMapping(value = DiagSpaceURIConstants.ALERTS, method = RequestMethod.GET)
	public @ResponseBody List<Alert> getAlerts() {
	// public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable long id) {
     //public ResponseEntity <List<com.diagknowlogy.spring.model.Alert>> getAlerts() {
        logger.info("Start getAlerts");
        
        List<com.diagknowlogy.spring.model.Alert> alerts = new ArrayList<com.diagknowlogy.spring.model.Alert>();
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        
        String query = "SELECT alert_ID, alert_Number, alert_description  FROM Alerts ORDER BY alert_ID";
        try {           
            connection = getConnection();
            //statement = connection.createStatement();
            CallableStatement cstmt = connection.prepareCall("{call getAlerts()}");
            rs = cstmt.executeQuery();
            //rs = statement.executeQuery(query);
            int i =0;
            
            while (rs.next()) {
            	com.diagknowlogy.spring.model.Alert alert = new com.diagknowlogy.spring.model.Alert();
            	i++;
                alert.setAlertId(rs.getInt("alert_ID"));
                alert.setAlertNumber(rs.getString("alert_Number"));
                alert.setAlertDesc(rs.getString("alert_description"));
                alerts.add(alert);
            }
            rs.close();
            //statement.close();
            cstmt.close();
 			logger.info("Number of records : "+ i);
        } catch (SQLException e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info("Error : "+ errors.toString());
        } finally {
            if (connection != null) {
                ReleaseConnection (connection);
            }
        } 
        
        return alerts;
       
        /*
       HttpHeaders headers = addAccessControllAllowOrigin();
        ResponseEntity <List<com.diagknowlogy.spring.model.Alert>> entity 
        	= new ResponseEntity <List<com.diagknowlogy.spring.model.Alert>>(alerts, headers, HttpStatus.OK);
        return entity;
       */ 
    }

	@RequestMapping(value = DiagSpaceURIConstants.PROBLEMINFO, method = RequestMethod.GET)
	public @ResponseBody ProblemInfo getProblemInfo() {
        logger.info("Start getProblemInfo");
        
        List <Who> localUpdate = new ArrayList<Who>();
        localUpdate.add(new Who(new Date(), 0, ""));
        
        List <Who> localAccess = new ArrayList<Who>();
        localAccess.add(new Who(new Date(), 0, ""));

        List <Who> localAssigned = new ArrayList<Who>();
        localAssigned.add(new Who(new Date(), 0, ""));
        
        List <Comments> localComments = new ArrayList<Comments>();
        localComments.add(new Comments());

        
        ProblemInfo problemInfo = new ProblemInfo((long)2001, 
        		"2001", 
        		(long) 0, 
        		ProblemStatus.NEW, 
        		"Unhandled Exception", 
        		"host1.yourcompany.com", 
        		"1", 
        		"ShoppingCart", 
        		new Who(new Date(), 0, ""), 
        		localUpdate,  
        		localAccess, 
        		localAssigned, 
        		localComments);

        List<SymptomGraphPoint> localSymptomGraphPoints = new ArrayList<SymptomGraphPoint>();
        Date referenceDate = new Date(); 
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate, -10), 50));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-9), 20));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-8), 60));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-7), 45));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-6), 90));
        
        List<Date> localViolations = new ArrayList<Date>();
        
        localViolations.add(getDate(referenceDate, -8));

        List <KPI> kpis = new ArrayList<KPI>();
        KPI localKPI = new KPI("Minimum Free Memory Violated", localSymptomGraphPoints, localViolations);
        kpis.add(localKPI);
        problemInfo.setKpis(kpis);
        
        return problemInfo;
    }

	@RequestMapping(value = DiagSpaceURIConstants.MATCHINGPROBLEMS, method = RequestMethod.GET)
	public @ResponseBody MatchedProblem getMatchedProblem() {
        logger.info("Start getMatchedProblem");
        MatchedProblem matchedProblem = new MatchedProblem();
        
        matchedProblem.setConfidenceLevel("99.07");
        matchedProblem.setProgressLevel(ProgressLevel.NOT_EXPLORED_YET);
        
        return matchedProblem;
    }
	
	Date getDate(Date referenceDate, int HoursToAdd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(referenceDate);
        cal.add(Calendar.HOUR_OF_DAY, HoursToAdd);
        return cal.getTime();
	}
	
	private Connection getConnection()
	{ 
		logger.info("Inside getConnection");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "diagknowlogy_poc"; 
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "bitnami";
		try {
			logger.info("forName");
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			logger.info("Connected to the database");
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info("NO CONNECTION =("+ errors.toString());
		} 
		return conn;
	}
	
	private void ReleaseConnection (Connection conn)
	{
		try {
			conn.close();
			logger.info("Disconnected from database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			logger.info("Error while Close the connection =("+ errors.toString());
		}
	}
	
	 private HttpHeaders addAccessControllAllowOrigin() {
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("Access-Control-Allow-Origin", "*");
		 return headers;
		 }
}
