package ua.com.foxminded.malzam.racers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.malzam.racers.model.Racer;

class RacerReporterTest {
    
    private static final String ABBR_FILE  = "abbreviations_test.txt";
    private static final String START_FILE = "start_test.log";
    private static final String END_FILE   = "end_test.log";
    private static final String ABBR_FILE_TWO_LINE  = "abbreviations_test_two_line.txt";
    private static final String START_FILE_TWO_LINE = "start_test_two_line.log";
    private static final String END_FILE_TWO_LINE   = "end_test_two_line.log";
    private RacerReader reader = new RacerReader();
    private RacerReporter racerReporter = new RacerReporter();
    
    @Test
    public void buildReport_Expect_TargetText_IfFiles_IsSampleFiles() {
        Set<Racer> racers = reader.recieveRacers(ABBR_FILE, START_FILE, END_FILE);
        String actual = racerReporter.buildReport(racers);
        String expected = 
                " 1.Sebastian Vettel  | FERRARI                   | 1:04.415\n" + 
                " 2.Daniel Ricciardo  | RED BULL RACING TAG HEUER | 1:12.013\n" + 
                " 3.Valtteri Bottas   | MERCEDES                  | 1:12.434\n" + 
                " 4.Lewis Hamilton    | MERCEDES                  | 1:12.460\n" + 
                " 5.Stoffel Vandoorne | MCLAREN RENAULT           | 1:12.463\n" + 
                " 6.Kimi Raikkonen    | FERRARI                   | 1:12.639\n" + 
                " 7.Fernando Alonso   | MCLAREN RENAULT           | 1:12.657\n" + 
                " 8.Sergey Sirotkin   | WILLIAMS MERCEDES         | 1:12.706\n" + 
                " 9.Charles Leclerc   | SAUBER FERRARI            | 1:12.829\n" + 
                "10.Sergio Perez      | FORCE INDIA MERCEDES      | 1:12.848\n" + 
                "11.Romain Grosjean   | HAAS FERRARI              | 1:12.930\n" + 
                "12.Pierre Gasly      | SCUDERIA TORO ROSSO HONDA | 1:12.941\n" + 
                "13.Carlos Sainz      | RENAULT                   | 1:12.950\n" + 
                "14.Esteban Ocon      | FORCE INDIA MERCEDES      | 1:13.028\n" + 
                "15.Nico Hulkenberg   | RENAULT                   | 1:13.065\n" + 
                "-----------------------------------------------------------\n" + 
                "16.Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 1:13.179\n" + 
                "17.Marcus Ericsson   | SAUBER FERRARI            | 1:13.265\n" + 
                "18.Lance Stroll      | WILLIAMS MERCEDES         | 1:13.323\n" + 
                "19.Kevin Magnussen   | HAAS FERRARI              | 1:13.393\n" + 
                "";                  
        assertEquals(expected, actual);
    }
    
    @Test
    public void buildReport_Expect_TargetText_IfFiles_IsSampleFilesTwoLine() {
        Set<Racer> racers = reader.recieveRacers(
                ABBR_FILE_TWO_LINE, 
                START_FILE_TWO_LINE, 
                END_FILE_TWO_LINE);
        String actual = racerReporter.buildReport(racers);
        String expected = 
                " 1.Sebastian Vettel  | FERRARI                   | 1:04.415\n" + 
                " 2.Daniel Ricciardo  | RED BULL RACING TAG HEUER | 1:12.013\n" + 
                "";                  
        assertEquals(expected, actual);
    }
}
