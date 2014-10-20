package br.com.bracode.experiment;

import java.util.ArrayList;
import java.util.List;

import jplay.GameImage;
import br.com.bracode.gameobject.Grass;
import br.com.bracode.tools.Message;
import br.com.bracode.tools.Settings;


public class Environment {

	private static GameImage background;

	private static GameImage topbar;
	private static GameImage ground;

	private static GameImage close;
	private static GameImage home;
	
	private static List<Grass> grasses;

	public Environment() {
		background = new GameImage(Settings.img + "bg_green.png");
		
		grasses = new ArrayList<Grass>();
		
		int linha = 1;
		int coluna = 1;
		
		for (int i = 0; i < 100; i++) {
			
			grasses.add(new Grass("resources/imagens/bloco.png"));
			
			grasses.get(i).x = coluna * 70;
			grasses.get(i).y = 70 + (linha * 40);
			
			coluna++;
			
			if(coluna % 11 == 0){
				coluna = 1;
				linha++;
			}
		}

		close = new GameImage(Settings.img + "close.png");
		close.x = background.width - close.width;
		close.y = 0;

		home = new GameImage(Settings.img + "home.png");
		home.x = background.width - home.width;
		home.y = close.height;

		topbar = new GameImage(Settings.img + "topbar.png");
		topbar.x = 0;
		topbar.y = 0;

		ground = new GameImage(Settings.img + "ground.png");
		ground.x = 0;
		ground.y = topbar.height;
	}
	
	public static void draw() {
		background.draw();
		topbar.draw();
		ground.draw();
		home.draw();
		close.draw();
		for(Grass grass : grasses){
			grass.draw();
		}
	}

	public static void checkclick(){
		if (Settings.mouse.isOverObject(close) && Settings.mouse.isLeftButtonPressed()) {
			Message.exit();
		}
		
		if (Settings.mouse.isOverObject(home) && Settings.mouse.isLeftButtonPressed()) {
			Message.home();
		}
		
		if (Settings.mouse.isOverObject(background) && Settings.mouse.isLeftButtonPressed()) {
			System.out.println("bg");
		}
	}
}
