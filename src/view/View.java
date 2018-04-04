package view;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class View {
	
	public View()
	{
		if(!glfwInit())
		{
			throw new IllegalStateException("not inited");
		}
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		long window = glfwCreateWindow(640, 480, "hello", 0, 0);
		if(window==0){throw new IllegalStateException("not created");}
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width()-640)/2, (videoMode.height()-480)/2);
		glfwShowWindow(window);
		
		while (!glfwWindowShouldClose(window))
		{
			glfwPollEvents();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			glfwSwapBuffers(window);
		}
		
		glfwTerminate();
	}
}
