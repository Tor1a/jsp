package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

// ���� ����....... �ǽð����� ������ �ؾ��Ѵ�.
public class Game extends Thread {
	private int delay = 20; // �������� ��
	private int ufoDelay = 20; // ufo������ ��
	
	
	PlayerBullet playerBullet;
	UFO ufo;

	ArrayList<PlayerBullet> playerBulletList = new ArrayList<PlayerBullet>();
	ArrayList<UFO> ufoList = new ArrayList<UFO>();
	
	
	Player player = new Player(600, 600, 100);
	public boolean up,down,left,right,shoot;
	public int count = 0;
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			keyProcess();
			playerBulletAction();
			
			makeUFO(); // ufo�����
			ufoAction(); // ������� ufo �� ufoList�� �ִ� �͵� �ǽð����� ������ ������...
		}
	}
	public void ufoAction() {
		for(int i=0;i<ufoList.size();i++) {
			ufo = ufoList.get(i);
			ufo.moveY();
		}
	}
	public void playerBulletAction() {
		for(int i=0;i<playerBulletList.size();i++) {
			playerBullet = playerBulletList.get(i);
			playerBullet.shoot();
			
			for(int j=0;j<ufoList.size();j++) {
				ufo = ufoList.get(j);
				if( hitObject( new Rectangle(playerBullet.x,playerBullet.y,playerBullet.width,playerBullet.height),
						       new Rectangle(ufo.x,ufo.y,ufo.width,ufo.height)) ) {
					//�Ѿ˰� ufo�浹������...
					ufo.hp -= playerBullet.power;
					playerBulletList.remove(playerBullet);
					
				}
				if(ufo.hp<=0) {
					ufoList.remove(ufo);
				}
			}
			if(playerBullet.y<-30) {
				playerBulletList.remove(i);
			}
		}
	}
	//ufo  �����
	public void makeUFO() {
		if(count%ufoDelay==0) {
			ufo = new UFO(  (int)(Math.random()*(GamePanel.GAME_WIDTH - 200))+100,-100,20);
			ufoList.add(ufo);
			ufo.speedY = (int)(Math.random()*5)+5;
		}
	}
	
	//player �����̱�....
	public void keyProcess() {
		if(left) {
			if(player.x>0) {
				player.x-=player.speedX;
			}
		} 
		if(right) {
			if (player.x < 1130) {
				player.x+=player.speedX;
			}
		} 
		if(up) {
			if(player.y>0) {
				player.y-=player.speedY;
			}
		} 
		if(down) {
			if(player.y<730) {
				player.y+=player.speedY;
			}
		}
		if(shoot) {
			if(count%5==0) {
				playerBullet = new PlayerBullet(player.x+26,player.y-30,5);
				playerBulletList.add(playerBullet);
			}
			//System.out.println(playerBulletList.size());
		}
	}
	//player�� �׸���, ufo, bullet
	public void drawAll(Graphics g) {
		drawPlayer(g);
		drawPlayerBullet(g);
		drawUFO(g);
	}
	public void drawPlayer(Graphics g) {
		g.drawImage(player.image, player.x, player.y, null);
	}
	public void drawPlayerBullet(Graphics g) {
		for(int i=0;i<playerBulletList.size();i++) {
			playerBullet = playerBulletList.get(i);
			g.drawImage(playerBullet.image, playerBullet.x, playerBullet.y, null);
		}
	}
	public void drawUFO(Graphics g) {
		for(int i=0;i<ufoList.size();i++) {
			ufo = ufoList.get(i);
			g.drawImage(ufo.image, ufo.x, ufo.y, null);
		}
	}
	
	// �浹����....
	public boolean hitObject(Rectangle rect01,Rectangle rect02) {
		return rect01.intersects(rect02);
	}
}









