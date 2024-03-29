import Utilities.*;

class Helper extends MyObject implements Runnable {

   private int id = 0;
   private int napTime = 0; // milliseconds

   public Helper(String name, int id, int napTime) {
      super(name + " " + id);
      this.id = id;
      this.napTime = napTime;
      System.out.println(getName() + " is alive, napTime="
         + napTime);
   }

   public void run() {
      int napping;
      while (true) {
         napping = ((int) random(napTime)) + 1;
         System.out.println("age()=" + age() + ", " + getName()
            + " napping for " + napping + " ms");
         nap(napping);
      }
   }

}

class HelperThreads extends MyObject {

   public static void main(String[] args) {

      // parse command line arguments, if any, to override defaults
      GetOpt go = new GetOpt(args, "Uh:n:R:");
      go.optErr = true;
      String usage = "Usage: -h numHelpers -n napTime -R runTime";
      int ch = -1;
      int numHelpers = 4;
      int napTime = 3;    // defaults
      int runTime = 60;   // in seconds
      while ((ch = go.getopt()) != go.optEOF) {
         if      ((char)ch == 'U') {
            System.out.println(usage);  System.exit(0);
         }
         else if ((char)ch == 'h')
            numHelpers = go.processArg(go.optArgGet(), numHelpers);
         else if ((char)ch == 'n')
            napTime = go.processArg(go.optArgGet(), napTime);
         else if ((char)ch == 'R')
            runTime = go.processArg(go.optArgGet(), runTime);
         else {
            System.err.println(usage);  System.exit(1);
         }
      }
      System.out.println("HelperThreads: numHelpers=" + numHelpers
         + ", napTime=" + napTime + ", runTime=" + runTime);

      // seed the random number generator to get the same sequence
      // of pseudorandom numbers each time the program is run;
      // when the program is debugged, comment out this line
      // seed(42);

      // start the Helper threads
      Thread[] helper = new Thread[numHelpers];
      for (int i = 0; i < numHelpers; i++)
         helper[i] = new Thread(new Helper("Helper", i, napTime*1000));
      for (int i = 0; i < numHelpers; i++)
         helper[i].start();
      System.out.println("All Helper threads started");

      // let the Helpers run for a while
      nap(runTime*1000);
      System.out.println("age()=" + age()
         + ", time to stop the threads and exit");
      for (int i = 0; i < numHelpers; i++)
	  //helper[i].stop();
      System.exit(0);
   }
}

/* ............... Example compile and run(s)

D:\>javac muls.java

D:\>java HelperThreads -R 5
HelperThreads: numHelpers=4, napTime=3, runTime=5
Helper 0 is alive, napTime=3000
Helper 1 is alive, napTime=3000
Helper 2 is alive, napTime=3000
Helper 3 is alive, napTime=3000
All Helper threads started
age()=110, Helper 0 napping for 1354 ms
age()=110, Helper 1 napping for 2867 ms
age()=110, Helper 2 napping for 2291 ms
age()=110, Helper 3 napping for 2477 ms
age()=1590, Helper 0 napping for 2290 ms
age()=2520, Helper 2 napping for 867 ms
age()=2740, Helper 3 napping for 412 ms
age()=3070, Helper 1 napping for 2241 ms
age()=3130, Helper 3 napping for 1039 ms
age()=3400, Helper 2 napping for 1825 ms
age()=3840, Helper 0 napping for 34 ms
age()=3900, Helper 0 napping for 2978 ms
age()=4170, Helper 3 napping for 401 ms
age()=4610, Helper 3 napping for 2218 ms
age()=5100, time to stop the threads and exit
                                            ... end of example run(s)  */
