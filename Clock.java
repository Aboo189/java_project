import java.text.SimpleDateFormat;
class Clock
    {
        private static Clock instance = null;
        private static SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        private static java.util.Date currentTime = new java.util.Date();

        private Clock() {}

        public static Clock getInstance()
        {
            if (instance == null)
            {
                instance = new Clock();
            }
            return instance;
        }

        public void setTime(java.util.Date time) {
            currentTime = time;
        }

        public static String getTime() {
            return dateFormat.format(currentTime);
        }

    }

class Singleton // design pattern - Singleton
{
    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void SetUp() {
        System.out.println("Date: 22.02.2023");
    }
}

