package generaltests;

	import org.testng.IRetryAnalyzer;
	import org.testng.ITestResult;

	public class Retry implements IRetryAnalyzer {

	    private static final int MAX_RETRY_COUNT = 2;
	    private int retryCount = 0;

	    @Override
	    public boolean retry(ITestResult result) {
	    	 if(ITestResult.FAILURE==result.getStatus())
			  {
	        if (retryCount < MAX_RETRY_COUNT) {
	           
	            retryCount++;
	            return true;
	        }
			  }
	        return false;
	    }
	    
	}
