package _03_To_Do_List;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	List<String> task;
	public static void main(String[] args) {
		ToDoList run = new ToDoList();
		run.start();
		run.load();
	}
	void start() {
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton();
		view = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		task = new ArrayList<String>();
		
		add.setText("Add tasks");
		view.setText("View tasks");
		remove.setText("Remove tasks");
		save.setText("Save tasks");
		load.setText("Load tasks");
		
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			String text = JOptionPane.showInputDialog("What task do you want to add?");
			task.add(text);
		}
		if(e.getSource()==view) {
			String text2 = "";
			for(int i = 0; i < task.size(); i++) {
				if(i==0) {
					text2 = text2+task.get(i);
				}
				else {
					text2 = text2+"/n"+task.get(i);
				}
			}
			
		}
		if(e.getSource()==remove) {
			String tasks = JOptionPane.showInputDialog("What task would you like to remove?");
			task.remove(tasks);
		}
		if(e.getSource()==save) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/file.txt");
				for (String taskss : task) {
					for (char c : taskss.toCharArray()) {
						fw.append(c);
					}
					fw.append('\n');
				}
				
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==load) {
			load();
		}
		
	}
	void load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/test.txt"));
			
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
