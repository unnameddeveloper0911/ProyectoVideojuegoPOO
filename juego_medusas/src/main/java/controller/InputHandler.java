package controller;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Component;

/**
 * InputHandler básico usando JInput.
 * 
 * @author Miguel Arias
 * 
 * @version 0.0
 * 
 * Notas de version:
 * 0.0
 *  Actualmente esta clase es de prueba, no es la definitiva. 
 *  En el futuro se modificara para ser la clase InputHandler en la que se trabajara
 */
public class InputHandler {
    private Controller controller;
    private Component[] components;
    private float[] lastValues;

    public InputHandler() {
        findController();
    }

    private void findController() {
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for (Controller c : controllers) {
            Controller.Type t = c.getType();
            if (t == Controller.Type.GAMEPAD || t == Controller.Type.STICK) {
                controller = c;
                components = controller.getComponents();
                lastValues = new float[components.length];
                System.out.println("✓ Found controller: " + controller.getName());
                return;
            }
        }
        System.out.println("✗ No gamepad/stick controller found.");
    }

    public void poll() {
        if (controller == null) return;
        if (!controller.poll()) {
            System.out.println("Controller disconnected.");
            controller = null;
            return;
        }

        if (lastValues == null) {
            lastValues = new float[components.length];
            for (int i = 0; i < components.length; i++) {
                lastValues[i] = components[i].getPollData();
            }
            return;
        }

        for (int i = 0; i < components.length; i++) {
            float currentValue = components[i].getPollData();
            float delta = Math.abs(currentValue - lastValues[i]);

            if (delta > 0.2f) {
                lastValues[i] = currentValue;
            }
        }
    }

    // ==================== BOTONES PRINCIPALES ====================
    public boolean isXPressed() {
        return isButtonPressed("0");
    }

    public boolean isCirclePressed() {
        return isButtonPressed("1");
    }

    public boolean isSquarePressed() {
        return isButtonPressed("2");
    }

    public boolean isTrianglePressed() {
        return isButtonPressed("3");
    }

    // ==================== BUMPERS ====================
    public boolean isL1Pressed() {
        return isButtonPressed("4");
    }

    public boolean isR1Pressed() {
        return isButtonPressed("5");
    }

    // ==================== TRIGGERS ANALÓGICOS ====================
    public float getL2Value() {
        return getComponentValue("z");
    }

    public float getR2Value() {
        return getComponentValue("rz");
    }

    public boolean isL2Pressed() {
        return getL2Value() < -0.5f;
    }

    public boolean isR2Pressed() {
        return getR2Value() > 0.5f;
    }

    // ==================== STICK CLICKS ====================
    public boolean isL3Pressed() {
        return isButtonPressed("10");
    }

    public boolean isR3Pressed() {
        return isButtonPressed("11");
    }

    // ==================== SPECIAL BUTTONS ====================
    public boolean isPSButtonPressed() {
        return isButtonPressed("12");
    }

    public boolean isTouchpadPressed() {
        return isButtonPressed("13");
    }

    // ==================== D-PAD ====================
    public String getDPadDirection() {
        float povValue = getComponentValue("pov");
        if (povValue == 0.25f) return "UP";
        if (povValue == 0.5f) return "RIGHT";
        if (povValue == 0.75f) return "DOWN";
        if (povValue == 1.0f) return "LEFT";
        return "CENTER";
    }

    public boolean isDPadUp() {
        return getDPadDirection().equals("UP");
    }

    public boolean isDPadDown() {
        return getDPadDirection().equals("DOWN");
    }

    public boolean isDPadLeft() {
        return getDPadDirection().equals("LEFT");
    }

    public boolean isDPadRight() {
        return getDPadDirection().equals("RIGHT");
    }

    // ==================== LEFT STICK ====================
    public float getLeftStickX() {
        return getComponentValue("x");
    }

    public float getLeftStickY() {
        return getComponentValue("y");
    }

    public boolean isLeftStickMoving() {
        return Math.abs(getLeftStickX()) > 0.1f || Math.abs(getLeftStickY()) > 0.1f;
    }

    // ==================== RIGHT STICK ====================
    public float getRightStickX() {
        return getComponentValue("rx");
    }

    public float getRightStickY() {
        return getComponentValue("ry");
    }

    public boolean isRightStickMoving() {
        return Math.abs(getRightStickX()) > 0.1f || Math.abs(getRightStickY()) > 0.1f;
    }

    // ==================== HELPERS ====================
    private float getComponentValue(String identifierName) {
        if (controller == null) return 0f;
        for (Component comp : components) {
            if (comp.getIdentifier().getName().equals(identifierName)) {
                return comp.getPollData();
            }
        }
        return 0f;
    }

    private boolean isButtonPressed(String buttonId) {
        float v = getComponentValue(buttonId);
        return v > 0.5f;
    }

    public boolean isConnected() {
        return controller != null;
    }
    public static void main(String[] args) throws InterruptedException {
        InputHandler ih = new InputHandler();
        while (true) {
            ih.poll();
            Thread.sleep(100);
        }
    }
}