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
	
	JLabel text=new JLabel("   �w��Ө�W�Ť��ڽc");//�]�w�{�b���\��Ϊ��A��T
	JLabel nownumber=new JLabel("�{�b�������`��:0�A�Q�t�`��:0");
	Point p;
	JPanel bar=new JPanel();
	JPanel toolbar=new JPanel();
	JPanel downbar=new JPanel();
    int ForT=0;
    boolean delsel=false;
    int countfish=0;
    int countturtle=0;
	
	
	public Aquarium() throws IOException{
		super("���ڽc");
		setLayout(null);
		
		
		
		bar.setBounds(0, 50, 800, 500);//�D�n�����ڽc�e��
		bar.setVisible(true);
		bar.setBackground(Color.decode("#06C9C9"));
		add(bar);
		bar.setLayout(null);
		
		toolbar.setBounds(0, 0, 800, 50);//�W�誺�\��e��
		toolbar.setVisible(true);
		toolbar.setBackground(Color.decode("#C09A29"));
		add(toolbar);
		toolbar.setLayout(null);
		
		downbar.setBounds(0, 550, 800, 60);//�U�誺�ʪ��p�ƾ��εe��
		downbar.setVisible(true);
		downbar.setBackground(Color.decode("#0CCA0C"));
		add(downbar);
		downbar.setLayout(null);
		
		JButton newfish=new JButton("�s�W��");//��@���s
        newfish.setBounds(20,10, 90, 30);
		JButton newturtle=new JButton("�s�W�Q�t");
		newturtle.setBounds(120,10, 90, 30);
		JButton desel=new JButton("�������");
        desel.setBounds(220,10, 90, 30);
		JButton deall=new JButton("��������");
		deall.setBounds(320,10, 90, 30);
		
		text.setFont(new Font("Dialog",Font.BOLD,20));//��@�\����ܦr��
		text.setBounds(450, 5, 320, 40);
		text.setBackground(Color.decode("#339966"));
		text.setOpaque(true);
		
		nownumber.setFont(new Font("Dialog",Font.BOLD,20));//��@�ʪ��p�ƾ�
		nownumber.setBounds(20, 10, 500, 30);
		
		
		toolbar.add(newfish);
		toolbar.add(newturtle);
		toolbar.add(desel);
		toolbar.add(deall);
		toolbar.add(text);
		downbar.add(nownumber);
		
		
		bar.addMouseListener(//��@�e�����N�a�I�[�J���s�\��
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
								text.setText("�Х���n�l�곽�٬O�Q�t");
							}														
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
		
		
		newfish.addActionListener(new ActionListener() { //�s�W����
            public void actionPerformed(ActionEvent e) {                
                ForT=1;
                delsel=false;
                text.setText("�I����N�a�I�гy����");
            }});
		newturtle.addActionListener(new ActionListener() { //�s�W�Q�t
            public void actionPerformed(ActionEvent e) {                
                ForT=2;      
                delsel=false; 
                text.setText("�I����N�a�I�гy�Q�t");
            }});
		desel.addActionListener(new ActionListener() { //�R���I�諸�ͪ�
            public void actionPerformed(ActionEvent e) {                
                delsel=true; 
                text.setText("�{�b�I��i�����A�ð��γгy�\��");
            }});
		deall.addActionListener(new ActionListener() { //�R�������ͪ�
            public void actionPerformed(ActionEvent e) {  
            	int allan=countfish+countturtle;
                text.setText("�w�g��������"+allan+"���ʪ�");
                countfish=0;
                countturtle=0;
                nownumber.setText("�{�b�������`��:"+countfish+"�A"+"�Q�t�`��:"+countturtle);
                bar.removeAll();//�����Ҧ�jlabel
                bar.repaint();//���m�e��
            }});
		
		
	}
	
	public void createfish(Point p) throws IOException {//�гy�p���}�l
						
	JLabel newjlabel=new JLabel();	
	
   	 
	Thread th=new Thread(new Runnable() {
			public void run() {
				 
				
				Random r=new Random();
				Random wr=new Random();
				int i=r.nextInt(3)+1;//�H��������
				int w=wr.nextInt(80)+30;//�H�����j�p
				Random sx=new Random();
			   	Random sy=new Random();

			   	int firstx=p.x-30;//�վ��l��m
			   	int firsty=p.y-25;
			   	int speedx=sx.nextInt(20)-10;//�H�����t�פΤ��
			   	int speedy=sy.nextInt(20)-10;
			   	do {
			   	    speedx=sx.nextInt(20)-10;//�������|�u�������ʬƦܰ���
				   	speedy=sy.nextInt(20)-10;
			   	}while(speedx==0||speedy==0);
			  
			   	Icon Fish1=null;//��l�Ʒs���Ϥ�
				Icon Fish2=null;
				Icon Fish3=null;
				Icon Fish4=null;
				Icon Fish5=null;
				Icon Fish6=null;
				Icon Cookie=null;
				try {//���J�Ϥ�
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
				 
				
				if(i==1) {//�M�w��������
					if(speedx>0) {
					    newjlabel.setIcon(Fish1);//�M�w���Y��V
					}
					else {
						newjlabel.setIcon(Fish2);
					}
					text.setText("�A�l��F�e�b�A�a�I:"+p.x+","+p.y);
				}
				if(i==2) {
					if(speedx>0) {
					    newjlabel.setIcon(Fish3);
					}
					else {
						newjlabel.setIcon(Fish4);
					}
					text.setText("�A�l��F������K�A�a�I:"+p.x+","+p.y);
				}
				if(i==3) {
					if(speedx>0) {
					    newjlabel.setIcon(Fish5);
					}
					else {
						newjlabel.setIcon(Fish6);
					}
					text.setText("�A�l��F�p�����A�a�I:"+p.x+","+p.y);
				}
				

					for(int j= 10;; j+=10) {//�L���j��}�l 
						
						if(j>200) {//�w�����m���s���ʦV
							speedx=sx.nextInt(20)-10;
							speedy=sy.nextInt(20)-10;
						   	j=10;
						}
						
						if(speedx>0) {//�p�G���ʤ�V���ܡA��ۧ󴫹Ϥ�
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
		                         newjlabel.setBounds(firstx,firsty, w,w);	//��������                        
		                       		                     						
						}
						else {//��ɤϼu�t��
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
		nownumber.setText("�{�b�������`��:"+countfish+"�A"+"�Q�t�`��:"+countturtle);
		
		newjlabel.addMouseListener(//��@�I��H�R������
				new MouseAdapter() {
					public void mousePressed(MouseEvent event) {
						if(delsel) {
							newjlabel.setVisible(false);
							countfish--;
							nownumber.setText("�{�b�������`��:"+countfish+"�A"+"�Q�t�`��:"+countturtle);
							revalidate();
							repaint();
						}
					}
				});
		
		
		
	}
	
	public void createturtle(Point p) throws IOException{//�гy�Q�t�}�l
		
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
				   	int speedy=sy.nextInt(20)+7;//�Q�t�u�|���U��
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
					text.setText("�A�l��F�p�Q�t�A�a�I:"+p.x+","+p.y);
					
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
		nownumber.setText("�{�b�������`��:"+countfish+"�A"+"�Q�t�`��:"+countturtle);
		
		newjlabel2.addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent event) {
						if(delsel) {
							newjlabel2.setVisible(false);
							countturtle--;
							nownumber.setText("�{�b�������`��:"+countfish+"�A"+"�Q�t�`��:"+countturtle);
							revalidate();
							repaint();
						}
					}
				});
		
	}
	
     

}
