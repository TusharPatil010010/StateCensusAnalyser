package statecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

import statecensusanalyser.CensusAnalyserException;
import statecensusanalyser.StateCensus;
import statecensusanalyser.StateCensusAnalyser;

import java.io.IOException;

public class StateCensusAnalyserTest {
	public static final String STATECENSUS_CSVFILE = "C:\\Users\\LENOVO\\eclipse-workspace\\statecensusanalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	public static final String STATECODES_CSVFILE = null;
	public static final String WRONG_FILE = "/novalue.txt";

	@Test
	public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int count = stateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
			System.out.println(count);
			Assert.assertEquals(29, count);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
		try {
			int count = StateCensusAnalyser.openCsvBuilder(WRONG_FILE, StateCensus.class);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			Assert.assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
		}
	}
	
    @Test
    public void GivenTheStateCensusCsvFile_WhenCorrect_ButFileExtensionIncorrect_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }
}
