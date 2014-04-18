////package com.qiuxp.frame.mainframe;
//
//import static java.awt.BorderLayout.NORTH;
//import static java.awt.BorderLayout.SOUTH;
//import static javax.swing.border.BevelBorder.RAISED;
//
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.net.URL;
//import java.util.Date;
//
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSeparator;
//import javax.swing.JSplitPane;
//import javax.swing.JTree;
//import javax.swing.SwingConstants;
//import javax.swing.UIManager;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.DefaultMutableTreeNode;
//
//import com.qiuxp.frame.jinhuo.JinHuoDan_IFrame;
//import com.qiuxp.frame.jinhuo.JinHuoTuiHuo_IFrame;
//import com.qiuxp.frame.mainframe.panel.DesktopPanel;
//import com.qiuxp.frame.mainframe.panel.LeftTree;
//import com.qiuxp.frame.mainframe.panel.LogoPanel;
//import com.qiuxp.frame.mainframe.panel.MenuBar;
//import com.qiuxp.frame.mainframe.panel.ToolPanel;
//import com.qiuxp.frame.manage.ShangpinXinxiGuanli_IFrame;
//
///**
// * ��ҳ��
// */
//public class MainFrame extends JFrame implements TreeSelectionListener {
//   /**
//    * ����serialVersionUID
//    */
//    private static final long serialVersionUID = 4078673436342365451L;
//    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("��������ϵͳ");          // ��ڵ�
//    public DefaultMutableTreeNode getRoot() {
//        return root;
//    }
//
//
//    public LeftTree tree = new LeftTree(root,this);
//    private JScrollPane leftPane = new JScrollPane(tree);                                   // ������
//    private JSplitPane spPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
//    // �����ָ��(�ָ����)���� ��SplitPane(�ָ����)һ�οɽ��������ͬʱ��ʾ��������ʾ���У�������Ҫͬʱ�ڶ����ʾ����ʾ�����������ͬʱʹ�ö��SplitPane��
//    // JSplitPane�ṩ���������������õ�����Ҫˮƽ�ָ�Ǵ�ֱ�ָ����������ֱ��ǣ�HORIZONTAL_SPIT,VERTICAL_SPLIT.��
//
//    private JPanel rightPane = new JPanel();                                                // �Ҳ����
//    private DesktopPanel desktopPane = null;
//    private MenuBar frameMenuBar = null;
//    private JLabel stateLabel = null;
//    private JPanel statePanel = null;
//    private JLabel nameLabel = null;
//    private JPanel scoolPanel = null;
//    private JLabel scoolLabel = null;
//    private JLabel nowDateLabel = null;
//    private JPanel toolJpanel = null;
//    private JPanel logoPanel = null;
//    private JSeparator jSeparator = null;
//    private JSeparator jSeparator1 = null;
//    private JSeparator jSeparator2 = null;
//    private JSeparator jSeparator3 = null;
//    private static JLabel czyStateLabel = null;
//    private int labelLocation = 0;
//    private boolean flog = true;
//
//    /**
//     * ���캯��
//     */
//    public MainFrame() {
//        setVisible(true);
//        initRightPanel();
//        initialize();
//        addView();                                                                        // ��ӿؼ�
//        addListener();                                                                    // ע��������
//        threadRun();                                                                      // �����߳�
//    }
//
//    public void addListener() {
//        tree.addTreeSelectionListener(this);
//    }
//
//    /**
//     * ��ʼ��rightPael
//     */
//    public void initRightPanel() {
//        rightPane.setLayout(new BorderLayout());
//        rightPane.add(getDesktopPane());
//    }
//
//    /**
//     * ��ʼ���ָ����
//     */
//    public void addView() {
//        spPane.setLeftComponent(leftPane);                                               // �������Ĺ���������ӽ���
//        spPane.setRightComponent(rightPane);
//        spPane.setDividerLocation(182);                                                  // ���÷ָ����ĳ�ʼλ��
//        spPane.setDividerSize(1);
//        add(spPane);                                                                     // ��ӷָ����
//    }
//
//    /**
//     * �������¼�
//     */
//    public void valueChanged(TreeSelectionEvent e) {
//        JTree tree = (JTree) e.getSource();
//        // ��ô������¼��Ľڵ���󶨵��û����
//        String nodeValue = (String) ((DefaultMutableTreeNode) tree
//                .getLastSelectedPathComponent()).getUserObject();
//        if ("�����".equals(nodeValue)) {
//            frameMenuBar.createIFrame(frameMenuBar.getMenuitem().get("�����"),
//                    JinHuoDan_IFrame.class);
//        } else if ("����˻�".equals(nodeValue)) {
//            frameMenuBar.createIFrame(frameMenuBar.getMenuitem().get("����˻�"),
//                    JinHuoTuiHuo_IFrame.class);
//        } else if ("��Ʒ��Ϣ����".equals(nodeValue)) {
//            frameMenuBar.createIFrame(frameMenuBar.getMenuitem().get("��Ʒ���Ϲ���"),
//                    ShangpinXinxiGuanli_IFrame.class);
//        } else if("�˳�ϵͳ".equals(nodeValue)){
//            System.exit(0);
//        }
//    }
//
//    /**
//     * ��ʼ���������
//     */
//    private DesktopPanel getDesktopPane() {
//        if (desktopPane == null) {
//            desktopPane = new DesktopPanel();
//        }
//        return desktopPane;
//    }
//
//    /**
//     * ��ʼ������˵����ķ���
//     */
//    protected MenuBar getFrameMenuBar() {
//        if (frameMenuBar == null) {
//            frameMenuBar = new MenuBar(getDesktopPane(), getStateLabel(),this);
//        }
//        return frameMenuBar;
//    }
//
//    /**
//     * �������״̬��ǩ����
//     */
//    public JLabel getStateLabel() {
//        if (stateLabel == null) {
//            stateLabel = new JLabel();
//            stateLabel.setPreferredSize(new Dimension(174, 25));
//            stateLabel.setText("��ǰû��ѡ������ ");
//        }
//        return stateLabel;
//    }
//
//    /**
//     * ��ô��������״̬���
//     */
//    private JPanel getStatePanel() {
//        if (statePanel == null) {
//            GridBagLayout gb = new GridBagLayout();
//            GridBagConstraints gc = new GridBagConstraints();
//            GridBagConstraints gc1 = new GridBagConstraints();
//            GridBagConstraints gc2 = new GridBagConstraints();
//            GridBagConstraints gc3 = new GridBagConstraints();
//            GridBagConstraints gc4 = new GridBagConstraints();
//            GridBagConstraints gc5 = new GridBagConstraints();
//            GridBagConstraints gc6 = new GridBagConstraints();
//            GridBagConstraints gc7 = new GridBagConstraints();
//            GridBagConstraints gc8 = new GridBagConstraints();
//
//            nowDateLabel = new JLabel();
//            nameLabel = new JLabel("�Ͼ���Ϣ���̴�ѧ ");
//
//            statePanel = new JPanel();
//            statePanel.setLayout(gb);
//            statePanel.setBorder(BorderFactory.createBevelBorder(RAISED));
//            statePanel.add(getStateLabel());
//            statePanel.add(getJSeparator3());
//            statePanel.add(getScoolPanel());
//            statePanel.add(getJSeparator());
//            statePanel.add(getCzyStateLabel());
//            statePanel.add(getJSeparator1());
//            statePanel.add(nowDateLabel);
//            statePanel.add(getJSeparator2());
//            statePanel.add(nameLabel);
//
//            gc.gridx = 0;
//            gc.fill = GridBagConstraints.HORIZONTAL;
//            gc.weightx = 0;
//            gc.gridy = 0;
//            gb.setConstraints(getStateLabel(), gc);
//
//            gc8.gridx = GridBagConstraints.RELATIVE;
//            gc8.fill = GridBagConstraints.VERTICAL;
//            gc8.weighty = 1.0;
//            gc8.insets = new Insets(0, 5, 0, 5);
//            gc8.gridy = 0;
//            gb.setConstraints(getJSeparator3(), gc8);
//
//            gc1.gridx = GridBagConstraints.RELATIVE;
//            gc1.weightx = 1;
//            gc1.fill = GridBagConstraints.HORIZONTAL;
//            gb.setConstraints(getScoolPanel(), gc1);
//
//            gc2.gridx = GridBagConstraints.RELATIVE;
//            gc2.fill = GridBagConstraints.VERTICAL;
//            gc2.weighty = 1.0;
//            gc2.insets = new Insets(0, 5, 0, 5);
//            gc2.gridy = 0;
//            gb.setConstraints(getJSeparator(), gc2);
//
//            gc3.gridx = GridBagConstraints.RELATIVE;
//            gc3.weightx = 0.0;
//            gc3.fill = GridBagConstraints.NONE;
//            gc3.gridy = 0;
//            gb.setConstraints(nameLabel, gc3);
//
//            gc4.gridx = GridBagConstraints.RELATIVE;
//            gc4.fill = GridBagConstraints.VERTICAL;
//            gc4.insets = new Insets(0, 5, 0, 5);
//            gc4.gridy = 0;
//            gb.setConstraints(getJSeparator1(), gc4);
//
//            gc5.gridx = GridBagConstraints.RELATIVE;
//            gc5.insets = new Insets(0, 5, 0, 5);
//            gc5.gridy = 0;
//            gb.setConstraints(nowDateLabel, gc5);
//
//            gc6.gridx = GridBagConstraints.RELATIVE;
//            gc6.fill = GridBagConstraints.VERTICAL;
//            gc6.insets = new Insets(0, 5, 0, 5);
//            gc6.gridy = 0;
//            gb.setConstraints(getJSeparator2(), gc6);
//
//            gc7.gridx = GridBagConstraints.RELATIVE;
//            gc7.gridy = 0;
//            gb.setConstraints(getCzyStateLabel(), gc7);
//
//        }
//        return statePanel;
//    }
//
//    /**
//     * ��ù�����������
//     */
//    public JPanel getScoolPanel() {
//        if (scoolPanel == null) {
//            scoolPanel = new JPanel();
//            scoolPanel.setLayout(new BorderLayout());
//            scoolLabel = new JLabel("*****��ӭʹ�ý�������ϵͳ*****");
//            scoolPanel.add(scoolLabel, BorderLayout.EAST);
//        }
//        return scoolPanel;
//    }
//
//    /**
//     * ��ò���Ա
//     */
//    public static JLabel getCzyStateLabel() {
//        if (czyStateLabel == null) {
//            czyStateLabel = new JLabel("����Ա��");
//        }
//        return czyStateLabel;
//    }
//
//    /**
//     * ��ʼ������
//     */
//    private void initialize() {
//        this.setJMenuBar(getFrameMenuBar());
//        this.add(getStatePanel(), SOUTH);
//        this.setJMenuBar(getFrameMenuBar());
//        this.add(getToolJpanel(), NORTH);
//        this.setIconImage(new ImageIcon(this.getClass().getResource("/res/titleion.jpg")).getImage()); // ���ô���ͼ��
//        this.setTitle("��������ϵͳ");                                                                    // ���ô������
//        this.setBounds(0, 0, 900, 620);                                                                // ���ô����С
//        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-900) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height-600) / 2);  //���ô���λ��
//        this.setResizable(false);                                                                      // ��С���ɱ�
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    /**
//     * �����ָ���
//     */
//    private JSeparator getJSeparator() {
//        if (jSeparator == null) {
//            jSeparator = new JSeparator();
//            jSeparator.setOrientation(JSeparator.VERTICAL);                                           //������ֱ�ָ���  
//        }
//        return jSeparator;
//    }
//
//    /**
//     * �����ָ���1
//     */
//    private JSeparator getJSeparator1() {
//        if (jSeparator1 == null) {
//            jSeparator1 = new JSeparator();
//            jSeparator1.setOrientation(SwingConstants.VERTICAL);
//        }
//        return jSeparator1;
//    }
//
//    /**
//     * �����ָ���2
//     */
//    private JSeparator getJSeparator2() {
//        if (jSeparator2 == null) {
//            jSeparator2 = new JSeparator();
//            jSeparator2.setOrientation(SwingConstants.VERTICAL);
//        }
//        return jSeparator2;
//    }
//
//    /**
//     * �����ָ���3
//     */
//    private JSeparator getJSeparator3() {
//        if (jSeparator3 == null) {
//            jSeparator3 = new JSeparator();
//            jSeparator3.setOrientation(SwingConstants.VERTICAL);
//        }
//        return jSeparator3;
//    }
//
//    /**
//     * ��ù�������ť���
//     */
//    private JPanel getToolJpanel() {
//        if (toolJpanel == null) {
//            toolJpanel = new ToolPanel();
//            GridBagLayout gb = new GridBagLayout();
//            GridBagConstraints s = new GridBagConstraints();
//            toolJpanel.setLayout(gb);
//            logoPanel = new LogoPanel();
//            JButton j1 = createButton("�����");
//            j1.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    frameMenuBar.createIFrame(frameMenuBar.getMenuitem().get("�����"),
//                            JinHuoDan_IFrame.class);
//                }
//            });
//
//            JButton j2 = createButton("���۵�");
//            j2.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    
//                }
//            });
//
//            JButton j3 = createButton("�ͻ���ѯ");
//            j3.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                }
//            });
//
//            JButton j4 = createButton("��Ʒ��ѯ");
//            j4.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                }
//            });
//
//            JButton j5 = createButton("���۲�ѯ");
//            j5.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                }
//            });
//
//            JButton j6 = createButton("��������");
//            j6.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                }
//            });
//
//            JButton j7 = createButton("�л��ӽ�");
//            j7.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    if(flog){
//                    spPane.remove(leftPane);
//                    flog =false;
//                    }else{
//                        spPane.setLeftComponent(leftPane);
//                        spPane.setDividerLocation(182);
//                        flog = true;
//                    }
//                }
//            });
//
//            JButton j8 = createButton("�˳�ϵͳ");
//            j8.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    System.exit(0);
//                }
//            });
//
//            toolJpanel.add(logoPanel);
//            toolJpanel.add(j1);
//            toolJpanel.add(j2);
//            toolJpanel.add(j3);
//            toolJpanel.add(j4);
//            toolJpanel.add(j5);
//            toolJpanel.add(j6);
//            toolJpanel.add(j7);
//            toolJpanel.add(j8);
//
//            s.gridx = 0;
//            s.gridy = 0;
//            s.gridwidth = 2;
//            s.fill = GridBagConstraints.BOTH;
//            s.weightx = 1;
//            s.insets = new Insets(0, 0, 0, 17);
//            gb.setConstraints(logoPanel, s);
//            s.gridx = 2;
//            s.gridwidth = 1;
//            s.gridheight = 1;
//            s.weightx = 0;
//            gb.setConstraints(j1, s);
//            s.gridx = 3;
//            gb.setConstraints(j2, s);
//            s.gridx = 4;
//            gb.setConstraints(j3, s);
//            s.gridx = 5;
//            gb.setConstraints(j4, s);
//            s.gridx = 7;
//            gb.setConstraints(j5, s);
//            s.gridx = 6;
//            gb.setConstraints(j6, s);
//            s.gridx = 8;
//            gb.setConstraints(j7, s);
//            s.gridx = 9;
//            gb.setConstraints(j8, s);
//        }
//        return toolJpanel;
//    }
//
//    /**
//     * ������ť�ķ���
//     * @param fname �������� cname ��ť����
//     */
//    public JButton createButton(String name) {
//        
//        JButton jb = new JButton();
//        jb.setPreferredSize(new Dimension(70, 70));
//        URL url1 = this.getClass().getResource("/res/" + name + ".png");
//        URL url2 = this.getClass().getResource("/res/" + name + "Rollover.png");
//        URL url3 = this.getClass().getResource("/res/" + name + "Pressed.png");
//        ImageIcon icon1 = new ImageIcon(url1);
//        ImageIcon icon2 = new ImageIcon(url2);
//        ImageIcon icon3 = new ImageIcon(url3);
//
//        jb.setMargin(new Insets(0, 0, 0, 0));
//        jb.setFocusPainted(false);                                                     // ���ð�ť�޽���
//        jb.setBorderPainted(false);                                                    // ���ð�ť�ޱ߿�
//        jb.setContentAreaFilled(false);                                                // ���ð�ť͸��
//        jb.setIcon(icon1);                                                             // ���ð�ťͼ��
//        jb.setRolloverIcon(icon2);                                                     // ���ð�ť��꾭��ͼ��
//        jb.setPressedIcon(icon3);                                                      // ���ð�ť��갴��ͼ��
//
//        return jb;
//    }
//
//    /**
//     * threadRun()��������ʵ��scoolLael�Ĺ�����nowDateLabelʱ�����
//     */
//    public void threadRun() {
//        // ����һ���̣߳�����label
//        new Thread(new Runnable() {
//            public synchronized void run() {
//                labelLocation = scoolLabel.getLocation().x;
//                try {
//                    while (true) {
//                        scoolLabel.setLocation(labelLocation -= 2, 0);
//                        if (scoolLabel.getLocation().x + scoolLabel.getSize().width < 0) {
//                            scoolLabel.setLocation(scoolPanel.getSize().width, 0);
//                            labelLocation = scoolLabel.getLocation().x;
//                        }
//                        Thread.sleep(50);
//                    }
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        // ����һ���̣߳�����ʱ��
//        new Thread(new Runnable() {
//            @SuppressWarnings("deprecation")
//            public synchronized void run() {
//                try {
//                    while (true) {
//                        Date jhsjDate = new Date();
//                        nowDateLabel.setText(jhsjDate.toLocaleString());
//                        Thread.sleep(1000);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    /**
//     * ������������
//     * @param args
//     */
//    public static void main(String args[]) {
//        try {
//            // ����ͼ�ν������Ϊϵͳ���
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            new MainFrame();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
