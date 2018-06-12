package platform.environment;

import java.util.Map;

/**
 * The program demonstrates using of {@code System.genenv()} function.
 */
public class EnvMap {
    public static void main (String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }
    }
}