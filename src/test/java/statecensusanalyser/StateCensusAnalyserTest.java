package statecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

import statecensusanalyser.CensusAnalyserException;
import statecensusanalyser.StateCensus;
import statecensusanalyser.StateCensusAnalyser;

import java.io.IOException;

public class StateCensusAnalyserTest {
	public static final String STATECENSUS_CSVFILE = "C:\\Users\\LENOVO\\eclipse-workspace\\statecensusanalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	public static final String STATECODES_CSVFILE = "C:\\Users\\LENOVO\\eclipse-workspace\\StateCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
	public static final String WRONG_FILE = "/novalue.txt";

	@Test
	public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int count = stateCensusAnalyser.openCsvBuilderCensus(STATECODES_CSVFILE, StateCensus.class);
			System.out.println(count);
			Assert.assertEquals(29, count);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
	}

}
