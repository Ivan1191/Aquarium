import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aquarium extends JFrame{
	
	JLabel text=new JLabel("   歡迎來到超級水族箱");//設定現在的功能及狀態資訊
	JLabel nownumber=new JLabel("現在的魚隻總數:0，烏龜總數:0");
	Point p;
	JPanel bar=new JPanel();
	JPanel toolbar=new JPanel();
	JPanel downbar=new JPanel();
    int ForT=0;
    boolean delsel=false;
    int countfish=0;
    int countturtle=0;
	
	
	public Aquarium() throws IOException{
		super("水族箱");
		setLayout(null);
		
		
		
		bar.setBounds(0, 50, 800, 500);//主要的水族箱畫面
		bar.setVisible(true);
		bar.setBackground(Color.decode("#06C9C9"));
		add(bar);
		bar.setLayout(null);
		
		toolbar.setBounds(0, 0, 800, 50);//上方的功能畫面
		toolbar.setVisible(true);
		toolbar.setBackground(Color.decode("#C09A29"));
		add(toolbar);
		toolbar.setLayout(null);
		
		downbar.setBounds(0, 550, 800, 60);//下方的動物計數器用畫面
		downbar.setVisible(true);
		downbar.setBackground(Color.decode("#0CCA0C"));
		add(downbar);
		downbar.setLayout(null);
		
		JButton newfish=new JButton("新增魚");//實作按鈕
        newfish.setBounds(20,10, 90, 30);
		JButton newturtle=new JButton("新增烏龜");
		newturtle.setBounds(120,10, 90, 30);
		JButton desel=new JButton("移除選取");
        desel.setBounds(220,10, 90, 30);
		JButton deall=new JButton("移除全部");
		deall.setBounds(320,10, 90, 30);
		
		text.setFont(new Font("Dialog",Font.BOLD,20));//實作功能顯示字串
		text.setBounds(450, 5, 320, 40);
		text.setBackground(Color.decode("#339966"));
		text.setOpaque(true);
		
		nownumber.setFont(new Font("Dialog",Font.BOLD,20));//實作動物計數器
		nownumber.setBounds(20, 10, 500, 30);
		
		
		toolbar.add(newfish);
		toolbar.add(newturtle);
		toolbar.add(desel);
		toolbar.add(deall);
		toolbar.add(text);
		downbar.add(nownumber);
		
		
		bar.addMouseListener(//實作畫面任意地點加入魚群功能
				new MouseAdapter() {
					public void mousePressed(MouseEvent event) {
						try {
							if(ForT==1) {
								if(delsel==false) {
									createfish(event.getPoint());
								}						
							}
							else if(ForT==2) {
								if(delsel==false) {
									createturtle(event.getPoint());
								}					
							}
							else if(ForT==0) {
								text.setText("請先選要召喚魚還是烏龜");
							}														
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
		
		
		newfish.addActionListener(new ActionListener() { //新增魚隻
            public void actionPerformed(ActionEvent e) {                
                ForT=1;
                delsel=false;
                text.setText("點選任意地點創造魚隻");
            }});
		newturtle.addActionListener(new ActionListener() { //新增烏龜
            public void actionPerformed(ActionEvent e) {                
                ForT=2;      
                delsel=false; 
                text.setText("點選任意地點創造烏龜");
            }});
		desel.addActionListener(new ActionListener() { //刪除點選的生物
            public void actionPerformed(ActionEvent e) {                
                delsel=true; 
                text.setText("現在點選可移除，並停用創造功能");
            }});
		deall.addActionListener(new ActionListener() { //刪除全部生物
            public void actionPerformed(ActionEvent e) {  
            	int allan=countfish+countturtle;
                text.setText("已經移除全部"+allan+"隻動物");
                countfish=0;
                countturtle=0;
                nownumber.setText("現在的魚隻總數:"+countfish+"，"+"烏龜總數:"+countturtle);
                bar.removeAll();//移除所有jlabel
                bar.repaint();//重置畫面
            }});
		
		
	}
	
	public void createfish(Point p) throws IOException {//創造小魚開始
						
	JLabel newjlabel=new JLabel();	
	
   	 
	Thread th=new Thread(new Runnable() {
			public void run() {
				 
				
				Random r=new Random();
				Random wr=new Random();
				int i=r.nextInt(3)+1;//隨機的種類
				int w=wr.nextInt(80)+30;//隨機的大小
				Random sx=new Random();
			   	Random sy=new Random();

			   	int firstx=p.x-30;//調整初始位置
			   	int firsty=p.y-25;
			   	int speedx=sx.nextInt(20)-10;//隨機的速度及方位
			   	int speedy=sy.nextInt(20)-10;
			   	do {
			   	    speedx=sx.nextInt(20)-10;//讓魚不會只垂直移動甚至停止
				   	speedy=sy.nextInt(20)-10;
			   	}while(speedx==0||speedy==0);
			  
			   	Icon Fish1=null;//初始化新的圖片
				Icon Fish2=null;
				Icon Fish3=null;
				Icon Fish4=null;
				Icon Fish5=null;
				Icon Fish6=null;
				Icon Cookie=null;
				try {//載入圖片
					Fish1=new ImageIcon(ImageIO.read(new File("src/1.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
					Fish2=new ImageIcon(ImageIO.read(new File("src/2.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
					Fish3=new ImageIcon(ImageIO.read(new File("src/3.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
					Fish4=new ImageIcon(ImageIO.read(new File("src/4.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
					Fish5=new ImageIcon(ImageIO.read(new File("src/5.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
					Fish6=new ImageIcon(ImageIO.read(new File("src/6.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
					Cookie=new ImageIcon(ImageIO.read(new File("src/cookie.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
				} catch (IOException e) {
					e.printStackTrace();
				}			
				 
				
				if(i==1) {//決定魚隻種類
					if(speedx>0) {
					    newjlabel.setIcon(Fish1);//決定魚頭方向
					}
					else {
						newjlabel.setIcon(Fish2);
					}
					text.setText("你召喚了河豚，地點:"+p.x+","+p.y);
				}
				if(i==2) {
					if(speedx>0) {
					    newjlabel.setIcon(Fish3);
					}
					else {
						newjlabel.setIcon(Fish4);
					}
					text.setText("你召喚了擬刺尾鯛，地點:"+p.x+","+p.y);
				}
				if(i==3) {
					if(speedx>0) {
					    newjlabel.setIcon(Fish5);
					}
					else {
						newjlabel.setIcon(Fish6);
					}
					text.setText("你召喚了小丑魚，地點:"+p.x+","+p.y);
				}
				

					for(int j= 10;; j+=10) {//無限迴圈開始 
						
						if(j>200) {//定期重置魚群的動向
							speedx=sx.nextInt(20)-10;
							speedy=sy.nextInt(20)-10;
						   	j=10;
						}
						
						if(speedx>0) {//如果移動方向改變，跟著更換圖片
							if(i==1) {
								newjlabel.setIcon(Fish1);
							}
							else if(i==2) {
								newjlabel.setIcon(Fish3);
								
							}
							else if(i==3) {
								newjlabel.setIcon(Fish5);
							}
						}
						else {
							if(i==1) {
								newjlabel.setIcon(Fish2);
							}
							else if(i==2) {
								newjlabel.setIcon(Fish4);
							}
							else if(i==3) {
								newjlabel.setIcon(Fish6);
							}
						}
						
						
						
						
						if(firstx+w<800 && firstx>0 && firsty+w<450 && firsty>0) {
		                                        	 
		                         try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
		                         newjlabel.setBounds(firstx,firsty, w,w);	//魚隻移動                        
		                       		                     						
						}
						else {//邊界反彈系統
							if(firstx+w>=800 || firstx<=0) {
								speedx=-speedx;									
								
							}
							if(firsty+w>=450 || firsty<=0) {
								speedy=-speedy;
							}						    
						}
						
						firstx+=speedx;
						firsty+=speedy;
						
						
					}
											 
			}
		});	
		th.start();	
		bar.add(newjlabel);
		repaint();
		countfish++;
		nownumber.setText("現在的魚隻總數:"+countfish+"，"+"烏龜總數:"+countturtle);
		
		newjlabel.addMouseListener(//實作點選以刪除魚隻
				new MouseAdapter() {
					public void mousePressed(MouseEvent event) {
						if(delsel) {
							newjlabel.setVisible(false);
							countfish--;
							nownumber.setText("現在的魚隻總數:"+countfish+"，"+"烏龜總數:"+countturtle);
							revalidate();
							repaint();
						}
					}
				});
		
		
		
	}
	
	public void createturtle(Point p) throws IOException{//創造烏龜開始
		
		JLabel newjlabel2=new JLabel();
		Thread th=new Thread(new Runnable() {
				public void run() {
					Random wr=new Random();
					int w=wr.nextInt(80)+30;
					Random sx=new Random();
				   	Random sy=new Random();
				   	int firstx=p.x-30;
				   	int firsty=p.y-25;
				   	int speedx=sx.nextInt(20)-10;
				   	int speedy=sy.nextInt(20)+7;//烏龜只會往下掉
				   	do {
				   		speedx=sx.nextInt(20)-10;
					   	speedy=sy.nextInt(20)+7;
					   	
				   	}while(speedx==0||speedy==0);
					
					Icon Turtle1=null;
					Icon Turtle2=null;
					try {
						Turtle1=new ImageIcon(ImageIO.read(new File("src/w.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
						Turtle2=new ImageIcon(ImageIO.read(new File("src/w2.png")).getScaledInstance(w, w, Image.SCALE_AREA_AVERAGING));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					if(speedx>0) {
						newjlabel2.setIcon(Turtle1);
						
					}
					else {
						newjlabel2.setIcon(Turtle2);
					}
					text.setText("你召喚了小烏龜，地點:"+p.x+","+p.y);
					
					for(int j= 10;; j+=10) {
						
						if(j>150) {
							speedx=sx.nextInt(20)-10;
							j=10;
						}
						
						if(speedx>0) {								
							newjlabel2.setIcon(Turtle1);
						}
						else {
							newjlabel2.setIcon(Turtle2);
						}
						
						
						if(firstx+w<800 && firstx>0 && firsty+w<510) {
                       	 
	                         try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
	                         newjlabel2.setBounds(firstx,firsty, w,w);	                                               		                     						
					}
						else {
							if(firstx+w>=800 || firstx<=0) {
								speedx=-speedx;							
							}
							if(firsty+w>=520) {
								speedy=0;
								firsty=509-w;
							}
						}
						
						firstx+=speedx;
						if(firsty+w<520) {
							firsty+=speedy;
						}					
					}
				}
		});
		th.start();	
		bar.add(newjlabel2);
		repaint();
		countturtle++;
		nownumber.setText("現在的魚隻總數:"+countfish+"，"+"烏龜總數:"+countturtle);
		
		newjlabel2.addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent event) {
						if(delsel) {
							newjlabel2.setVisible(false);
							countturtle--;
							nownumber.setText("現在的魚隻總數:"+countfish+"，"+"烏龜總數:"+countturtle);
							revalidate();
							repaint();
						}
					}
				});
		
	}
	
     

}
