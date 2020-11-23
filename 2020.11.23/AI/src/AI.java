import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{
    Image heroImg[][]=new Image[4][3];
	Image bossImg;
	/*Image heroLeftImg[]=new Image[3];
    Image heroRightImg[]=new Image[3];    //一维数组定义
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];*/
	Thread thread;
	/*int leftFlag,rightFlag,upFlag,downFlag;*/
	int flag;
	Image currentImg;
	int heroX,heroY,bossX,bossY;
	public MainCanvas(){                          //  二位数组定义
	try
	{
        for(int i=0;i<heroImg.length;i++){
		    for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png"); 			
			}
		}
		bossImg=Image.createImage("/benzaiten.png");
		/*for(int i=0;i<heroLeftImg.length;i++){
		    heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");  //左
		
		}
		for(int i=0;i<heroRightImg.length;i++){                                 
			heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");  //右               //一维数组定义
		}
		for(int i=0;i<heroUpImg.length;i++){                                         
            heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");  //上
		}
		for(int i=0;i<heroDownImg.length;i++){
		    heroDownImg[i]=Image.createImage("/sayo"+i+"0.png"); //下
		}*/


		currentImg=heroImg[1][1];
		heroX=120;
		heroY=120;
	/*	leftFlag=1;
		rightFlag=1;
		upFlag=1;
		downFlag=1;*/
		bossX=0;
		bossY=0;
		flag=1;
		 
		thread=new Thread(this);
		thread.start();
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	 }
	}
/*在多线程里写一个死循环，不停地比较boss和hero的坐标*/
	public void run(){
		while(true){
			try{
				Thread.sleep(200);
			}
			catch(InterruptedException e){
				e.printStackTrace(); 
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}
			if(bossY<heroY){
				bossY++;	
			}
			else{
				bossY--;  
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,100,100);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	// 定义方法
	public void changePicAndDirtion(int dirtion){	      
		if(flag==1){
			currentImg=heroImg[dirtion][0];
			flag++;
		}
		else if(flag==2){
			currentImg=heroImg[dirtion][2];
			flag=1;
		}
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode); 
		if(action==LEFT){
			//调用方法
			changePicAndDirtion(2);
			System.out.println("向左走");
			heroX=heroX-3;
		}					
		else if(action==RIGHT){
			changePicAndDirtion(3);
			System.out.println("向右走");
			heroX=heroX+3;							
			 }
		else if(action==UP){
			changePicAndDirtion(0);	
			System.out.println("向上走");
			heroY=heroY-3;
		}	
		else if(action==DOWN){
			changePicAndDirtion(1);
			System.out.println("向下走");
			heroY=heroY+3;
		}		
	}	
}