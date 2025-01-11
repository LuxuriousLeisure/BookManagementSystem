public class LoadingHelper {
    
    public static void simulateLoading() {
        System.out.println("Loading...");
        try {
            Thread.sleep(1000); // 暂停1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void simulateExiting() {
        try {
            Thread.sleep(500); // 暂停0.5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
