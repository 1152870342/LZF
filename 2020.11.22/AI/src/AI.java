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
class MainCanvas extends Canvas
{
    Image heroImg[][]=new Image[4][3];

	/*Image heroLeftImg[]=new Image[3];
    Image heroRightImg[]=new Image[3];    //һά���鶨��
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];*/
	
	int Leftflag,Rightflag,Upflag,Downflag;
	Image currentImg;
	int x,y;
	public MainCanvas(){                          //  ��λ���鶨��
	try
	{
        for(int i=0;i<heroImg.length;i++){
		    for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png"); 			
			}
		}
		/*for(int i=0;i<heroLeftImg.length;i++){
		    heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");  //��
		
		}
		for(int i=0;i<heroRightImg.length;i++){                                 
			heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");  //��               //һά���鶨��
		}
		for(int i=0;i<heroUpImg.length;i++){                                         
            heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");  //��
		}
		for(int i=0;i<heroDownImg.length;i++){
		    heroDownImg[i]=Image.createImage("/sayo"+i+"0.png"); //��
		}*/


		currentImg=heroImg[1][1];
		x=120;
		y=120;
		Leftflag=1;
		Rightflag=1;
		Upflag=1;
		Downflag=1;
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	 }
	}
	public void paint(Graphics g){
		g.setColor(0,100,100);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode); 
	if(action==LEFT){
		
		 if(Leftflag==1){
			currentImg=heroImg[2][0];
			Leftflag++;
		}
		else if(Leftflag==2){
			currentImg=heroImg[2][2];
			Leftflag=1;
		}
			System.out.println("������");
				x=x-3;
	}
	
	else if(action==RIGHT){
	         if(Rightflag==1){
						currentImg=heroImg[3][0];
							Rightflag++;
			 }

		else if(Rightflag==2){
			currentImg=heroImg[3][2];
			Rightflag=1;
		}
System.out.println("������");
		x=x+3;
	}
	
	else if(action==UP){
	if(Upflag==1){
		currentImg=heroImg[0][0];	
		Upflag++;
	}
		else if(Upflag==2){
			currentImg=heroImg[0][2];
			Upflag=1;
		}
	System.out.println("������");
			y=y-3;
	}

	else if (action==DOWN){
		if(Downflag==1){
			currentImg=heroImg[1][0];
			Downflag++;	
	    }
		else if(Downflag==2){
			currentImg=heroImg[1][2];
			Downflag=1;
		System.out.println("������");
	     }
		y=y+3;
    }

	repaint();
  }	
}