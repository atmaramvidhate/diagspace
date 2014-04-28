package com.diagknowlogy.diagspace;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class DiagSpaceController {
	private static final Logger logger = LoggerFactory.getLogger(DiagSpaceController.class);
	
	@RequestMapping(value = DiagSpaceURIConstants.ALERTS, method = RequestMethod.GET)
	public @ResponseBody List<Alert> getAlerts() {
        logger.info("Start getAlerts");
        
        List<Alert> alerts = new ArrayList<Alert>();
        alerts.add(new Alert(1001, "1001", "This is My First Alert"));
        alerts.add(new Alert(1002, "1002", "This is My Second Alert"));
        alerts.add(new Alert(1003, "1003", "This is My Third Alert"));
        alerts.add(new Alert(1004, "1004", "This is My Fourth Alert"));
        alerts.add(new Alert(1005, "1005", "This is My Fifth Alert"));
        alerts.add(new Alert(1006, "1006", "This is My Sixth Alert"));
        alerts.add(new Alert(1007, "1007", "This is My Seventh Alert"));

        return alerts;
    }

	@RequestMapping(value = DiagSpaceURIConstants.PROBLEMINFO, method = RequestMethod.GET)
	public @ResponseBody ProblemInfo getProblemInfo() {
        logger.info("Start getProblemInfo");
        
        List <Who> localUpdate = new ArrayList<Who>();
        localUpdate.add(new Who(new Date(), 0, ""));
        
        List <Who> localAccess = new ArrayList<Who>();
        localAccess.add(new Who(new Date(), 0, ""));

        ProblemInfo problemInfo = new ProblemInfo(2001, "2001", "", ProblemStatus.NEW, "Unhandled Exception", 
        		"host1.yourcompany.com", "1", "ShoppingCart", new Who(new Date(), 0, ""), localUpdate,  localAccess, new Who(new Date(), 0, ""), null);
        
        return problemInfo;
    }

	@RequestMapping(value = DiagSpaceURIConstants.MATCHINGPROBLEMS, method = RequestMethod.GET)
	public @ResponseBody MatchedProblem getMatchedProblem() {
        logger.info("Start getMatchedProblem");
        MatchedProblem matchedProblem = new MatchedProblem();
        
        matchedProblem.setNumber("10001");
        matchedProblem.setDescription("Memeory too Low");
        matchedProblem.setConfidenceLevel("99.07");
        matchedProblem.setProgressLevel(ProgressLevel.NOT_EXPLORED_YET);
        


        List<SymptomGraphPoint> localSymptomGraphPoints = new ArrayList<SymptomGraphPoint>();
        Date referenceDate = new Date(); 
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate, -10), 50));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-9), 20));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-8), 60));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-7), 45));
        localSymptomGraphPoints.add(new SymptomGraphPoint(getDate(referenceDate,-6), 90));
        
        List<Date> localViolations = new ArrayList<Date>();
        
        localViolations.add(getDate(referenceDate, -8));
        KPI localKPI = new KPI("Minimum Free Memory Violated", localSymptomGraphPoints, localViolations);
        matchedProblem.setKpi(localKPI);
        
        return matchedProblem;
    }
	
	Date getDate(Date referenceDate, int HoursToAdd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(referenceDate);
        cal.add(Calendar.HOUR_OF_DAY, HoursToAdd);
        return cal.getTime();
	}
}
