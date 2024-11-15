package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.xml.namespace.QName;
import java.security.PublicKey;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Web Dev", new Employer("Walmart"),
                new Location("East St. Louis"), new PositionType("Full Stack"),
                new CoreCompetency("Grit"));
        Job job2 = new Job("Web Dev", new Employer("Walmart"),
                new Location("East St. Louis"), new PositionType("Full Stack"),
                new CoreCompetency("Grit"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Web Dev", new Employer("Walmart"),
                new Location("East St. Louis"), new PositionType("Full Stack"),
                new CoreCompetency("Grit"));
        String newLine = System.lineSeparator();
        String jobString = job1.toString();
        String jobStart = newLine;
        String jobEnd = newLine;

        assertTrue(jobString.startsWith(newLine) && jobString.endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String newLine = System.lineSeparator();
        Job job1 = new Job("Web Dev", new Employer("Walmart"),
                new Location("East St. Louis"), new PositionType("Full Stack"),
                new CoreCompetency("Grit"));
        String jobString = job1.toString();
        String expectedFormat = newLine +"ID: " + job1.getId() + newLine +
                "Name: Web Dev" + newLine +
                "Employer: Walmart" + newLine +
                "Location: East St. Louis" + newLine +
                "Position Type: Full Stack" + newLine +
                "Core Competency: Grit" + newLine;
        assertEquals(expectedFormat, jobString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String newLine = System.lineSeparator();
        Job job1 = new Job("Web Dev", new Employer("Walmart"),
                new Location(""), new PositionType("Full Stack"),
                new CoreCompetency("Grit"));
        String jobString = job1.toString();
        String expectedFormat = newLine +"ID: " + job1.getId() + newLine +
                "Name: Web Dev" + newLine +
                "Employer: Walmart" + newLine +
                "Location: Data not available" + newLine +
                "Position Type: Full Stack" + newLine +
                "Core Competency: Grit" + newLine;

        assertEquals(expectedFormat, jobString);
    }


}
