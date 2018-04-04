import controller.Controller;
import model.Model;
import view.View;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
	}

}
