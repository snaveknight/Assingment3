package a3;

import javax.swing.*; 

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;

public class GUI extends JPanel implements ActionListener {
	
	private static final String CSV_FILE_PATH = "Assignment3\\data\\books.csv";

	private JTextField searchField;
	private JTable bookListTable;
	private JComboBox<String> comboBoxOrder;
	private final ButtonGroup buttonGroupSearch = new ButtonGroup();
	private final ButtonGroup buttonGroupOrder = new ButtonGroup();
	private String currentAmount = "Top Ten";
	private String currentDirection = "Ascending";
	private String currentOrder = "Default";
	
	public static BookLibrary bl;

	public GUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTools = new JPanel();
		add(panelTools, BorderLayout.NORTH);
		GridBagLayout gbl_panelTools = new GridBagLayout();
		gbl_panelTools.columnWidths = new int[]{160, 0, 0};
		gbl_panelTools.rowHeights = new int[] {105, 0};
		gbl_panelTools.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_panelTools.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelTools.setLayout(gbl_panelTools);
		
		JPanel panelSearch = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSearch.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelSearch.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Look Up", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelSearch = new GridBagConstraints();
		gbc_panelSearch.fill = GridBagConstraints.BOTH;
		gbc_panelSearch.insets = new Insets(0, 0, 0, 5);
		gbc_panelSearch.gridx = 0;
		gbc_panelSearch.gridy = 0;
		panelTools.add(panelSearch, gbc_panelSearch);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSearch.add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel lblSearch = new JLabel("Search: ");
		lblSearch.setDisplayedMnemonic('S');
		horizontalBox.add(lblSearch);
		
		searchField = new JTextField();
		lblSearch.setLabelFor(searchField);
		horizontalBox.add(searchField);
		searchField.setColumns(10);
		searchField.addActionListener(this);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(20, 10));
		rigidArea.setMinimumSize(new Dimension(20, 10));
		verticalBox.add(rigidArea);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		horizontalBox_1.add(verticalBox_2);
		
		JRadioButton rdbtnBookId = new JRadioButton("Book ID");
		rdbtnBookId.setSelected(true);
		buttonGroupSearch.add(rdbtnBookId);
		verticalBox_2.add(rdbtnBookId);
		
		JRadioButton rdbtnISBN = new JRadioButton("ISBN");
		buttonGroupSearch.add(rdbtnISBN);
		verticalBox_2.add(rdbtnISBN);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);
		
		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		verticalBox_3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		horizontalBox_1.add(verticalBox_3);
		
		JButton btnSearch = new JButton("Find");
		btnSearch.setActionCommand("search");
		btnSearch.addActionListener(this);
		verticalBox_3.add(btnSearch);
		
		JPanel panelView = new JPanel();
		panelView.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "View", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		GridBagConstraints gbc_panelView = new GridBagConstraints();
		gbc_panelView.fill = GridBagConstraints.BOTH;
		gbc_panelView.insets = new Insets(0, 0, 0, 5);
		gbc_panelView.gridx = 1;
		gbc_panelView.gridy = 0;
		panelTools.add(panelView, gbc_panelView);
		
		Box verticalBox_6 = Box.createVerticalBox();
		panelView.add(verticalBox_6);
		
		JButton btnTopTen = new JButton("Top Ten");
		btnTopTen.setActionCommand("topten");
		btnTopTen.addActionListener(this);
		btnTopTen.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_6.add(btnTopTen);
		
		JButton btnFull = new JButton("Full List");
		btnFull.setActionCommand("full");
		btnFull.addActionListener(this);
		btnFull.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_6.add(btnFull);
		
		JPanel panelOrder = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelOrder.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		panelOrder.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Order By", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelOrder = new GridBagConstraints();
		gbc_panelOrder.fill = GridBagConstraints.BOTH;
		gbc_panelOrder.gridx = 2;
		gbc_panelOrder.gridy = 0;
		panelTools.add(panelOrder, gbc_panelOrder);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelOrder.add(verticalBox_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_2);
		
		Box verticalBox_4 = Box.createVerticalBox();
		verticalBox_4.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		horizontalBox_2.add(verticalBox_4);
		
		//JComboBox<String> comboBoxOrder = new JComboBox<String>();
		comboBoxOrder = new JComboBox<String>();
		comboBoxOrder.setModel(new DefaultComboBoxModel<String>(new String[] {"Default", "Author", "Original Publication Year"}));
		comboBoxOrder.addActionListener(this);
		verticalBox_4.add(comboBoxOrder);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_4.add(verticalGlue);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setMaximumSize(new Dimension(20, 150));
		rigidArea_1.setPreferredSize(new Dimension(10, 76));
		rigidArea_1.setMinimumSize(new Dimension(10, 10));
		horizontalBox_2.add(rigidArea_1);
		
		Box verticalBox_5 = Box.createVerticalBox();
		verticalBox_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_2.add(verticalBox_5);
		
		JRadioButton rdbtnAscending = new JRadioButton("Ascending");
		rdbtnAscending.setSelected(true);
		buttonGroupOrder.add(rdbtnAscending);
		verticalBox_5.add(rdbtnAscending);
		
		JRadioButton rdbtnDescending = new JRadioButton("Descending");
		buttonGroupOrder.add(rdbtnDescending);
		verticalBox_5.add(rdbtnDescending);
		
		Component glue = Box.createGlue();
		verticalBox_5.add(glue);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_5.add(horizontalBox_3);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_1);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setActionCommand("order");
		btnOrder.addActionListener(this);
		btnOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_3.add(btnOrder);
		
		// Book List Table View
		// Starts with the top ten.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);

		bookListTable = new JTable(new BookTableModel());
		bookListTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		bookListTable.setColumnSelectionAllowed(true);
		bookListTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(bookListTable);
		
	}

	class BookTableModel extends AbstractTableModel {
		public String[] tableHeaders = {"Book ID", 
										"Goodreads Book ID", 
										"Best Book ID", 
										"Work ID", 
										"Books Count", 
										"ISBN", 
										"ISBN 13", 
										"Authors", 
										"Orig. Pub. Year", 
										"Orig. Title", 
										"Title", 
										"Language Code", 
										"Average Rating", 
										"Ratings Count", 
										"Work Ratings Cnt", 
										"Work Txt Reviews Cnt", 
										"Ratings 1", 
										"Ratings 2", 
										"Ratings 3",
										"Ratings 4", 
										"Ratings 5", 
										"Image URL", 
										"Small Image URL"};

		public String[][] tableData = null;

		public BookTableModel() {
			int rows = 0;
			if (currentAmount.equals("Top Ten")) {
				rows = 10;
				System.out.println("TT: " + rows);
			}
			if (currentAmount.equals("Full List")) {
				rows = 10000;
				System.out.println("FL: " + rows);
			}
			this.tableData = currentView(rows);
		}

		public String[][] currentView(int rowAmount) {
			int columns = 23;
			int rows = rowAmount;
			String[][] currentTableView = null;

			List<Book> orderedList = bl.bookListLL;
			
			currentTableView = new String[rows][columns];
			if (currentOrder.equals("Author")) {
				if (currentDirection.equals("Ascending")) {
					Collections.sort(orderedList, new AuthorComparator());
				}
				else { // Descending
					Collections.sort(orderedList, new AuthorComparator().reversed());
				}
			}
			else if (currentOrder.equals("Original Publication Year")) {
				if (currentDirection.equals("Ascending")) {
					Collections.sort(orderedList, new PublicationComparator());
				}
				else { // Descending
					Collections.sort(orderedList, new PublicationComparator().reversed());
				}
			}
			else { // Default - Book ID
				if (currentDirection.equals("Ascending")) {
					orderedList = bl.bookListLL;
				}
				if (currentDirection.equals("Descending")) {
					Collections.reverse(orderedList);
				}
			}

			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < columns; j++) {
					switch(j) {
						case 0:
							currentTableView[i][j] = orderedList.get(i).book_id;
							break;
						case 1:
							currentTableView[i][j] = orderedList.get(i).goodreads_book_id;
							break;
						case 2:
							currentTableView[i][j] = orderedList.get(i).best_book_id;
							break;
						case 3:
							currentTableView[i][j] = orderedList.get(i).work_id;
							break;
						case 4:
							currentTableView[i][j] = orderedList.get(i).books_count;
							break;
						case 5:
							currentTableView[i][j] = orderedList.get(i).isbn;
							break;
						case 6:
							currentTableView[i][j] = orderedList.get(i).isbn13;
							break;
						case 7:
							currentTableView[i][j] = orderedList.get(i).authors;
							break;
						case 8:
							currentTableView[i][j] = orderedList.get(i).original_publication_year;
							break;
						case 9:
							currentTableView[i][j] = orderedList.get(i).original_title;
							break;
						case 10:
							currentTableView[i][j] = orderedList.get(i).title;
							break;
						case 11:
							currentTableView[i][j] = orderedList.get(i).language_code;
							break;
						case 12:
							currentTableView[i][j] = orderedList.get(i).average_rating;
							break;
						case 13:
							currentTableView[i][j] = orderedList.get(i).ratings_count;
							break;
						case 14:
							currentTableView[i][j] = orderedList.get(i).work_ratings_count;
							break;
						case 15:
							currentTableView[i][j] = orderedList.get(i).work_text_reviews_count;
							break;
						case 16:
							currentTableView[i][j] = orderedList.get(i).ratings_1;
							break;
						case 17:
							currentTableView[i][j] = orderedList.get(i).ratings_2;
							break;
						case 18:
							currentTableView[i][j] = orderedList.get(i).ratings_3;
							break;
						case 19:
							currentTableView[i][j] = orderedList.get(i).ratings_4;
							break;
						case 20:
							currentTableView[i][j] = orderedList.get(i).ratings_5;
							break;
						case 21:
							currentTableView[i][j] = orderedList.get(i).image_url;
							break;
						case 22:
							currentTableView[i][j] = orderedList.get(i).small_image_url;
							break;
					}
				}
			}
			return currentTableView;
		}

		public int getRowCount() { return tableData.length; }

		public int getColumnCount() { return tableHeaders.length; }
		
		public String getColumnName(int col) { return tableHeaders[col]; }

		public String getValueAt(int rowIndex, int columnIndex) {
			return tableData[rowIndex][columnIndex];
		}
		
		public void setValueAt(String value, int row, int col) {
			tableData[row][col] = value;
			fireTableCellUpdated(row, col);
		}

		public void refresh() {
			fireTableDataChanged();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if ("search".equals(e.getActionCommand())) {
			System.out.println("Search Pressed");
			
			// Gather the search string.
			String searchString = searchField.getText();

			// Gather which radio button is selected.
			String selectedBtn = null;
			Enumeration<AbstractButton> allSearchRdbtn = buttonGroupSearch.getElements();
			while(allSearchRdbtn.hasMoreElements()) {
				JRadioButton temp = (JRadioButton)allSearchRdbtn.nextElement();
				if (temp.isSelected()) {
					selectedBtn = temp.getText();
				}
			}
			
			Book result = null;
			if (selectedBtn.equals("Book ID")) {
				result = bl.getSearchID(searchString);
				if (result != null) {
					Component frame = null;
					String displayResult = 
								"Book ID: " + result.getBook_id() + 
								"\nGoodreads Book ID: " + result.getGoodreads_book_id() + 
								"\nBest Book ID:" + result.getBest_book_id() +
								"\nWork ID: " + result.getWork_id() +
								"\nBooks Count: " + result.getBooks_count() +  
								"\nISBN: " + result.getIsbn() +
								"\nISBN 13: " + result.getIsbn13() +
								"\nAuthors: " + result.getAuthors() +
								"\nOrig. Pub. Year: " + result.getOriginal_publication_year() + 
								"\nOrig. Title: " + result.getOriginal_title() +
								"\nTitle: " + result.getTitle() +
								"\nLanguage Code: " + result.getLanguage_code() +
								"\nAverage Rating: " + result.getAverage_rating() +
								"\nRatings Count: " + result.getRatings_count() +
								"\nWork Ratings Cnt: " + result.getWork_ratings_count() +
								"\nWork Txt Reviews Cnt: " + result.getWork_text_reviews_count() + 
								"\nRatings 1: " + result.getRatings_1() +
								"\nRatings 2: " + result.getRatings_2() +
								"\nRatings 3: " + result.getRatings_3() +
								"\nRatings 4: " + result.getRatings_4() +
								"\nRatings 5: " + result.getRatings_5() + 
								"\nImage URL: " + result.getImage_url() +
								"\nSmall Image URL: " + result.getSmall_image_url() + "";
					JOptionPane.showMessageDialog(frame, displayResult);
				}
			}
			if (selectedBtn.equals("ISBN")) {
				System.out.println(searchString);
				result = bl.getSearchISBN(searchString);
				if(result != null) {
					Component frame = null;
					String displayResult = 
								"Book ID: " + result.getBook_id() + 
								"\nGoodreads Book ID: " + result.getGoodreads_book_id() + 
								"\nBest Book ID:" + result.getBest_book_id() +
								"\nWork ID: " + result.getWork_id() +
								"\nBooks Count: " + result.getBooks_count() +  
								"\nISBN: " + result.getIsbn() +
								"\nISBN 13: " + result.getIsbn13() +
								"\nAuthors: " + result.getAuthors() +
								"\nOrig. Pub. Year: " + result.getOriginal_publication_year() + 
								"\nOrig. Title: " + result.getOriginal_title() +
								"\nTitle: " + result.getTitle() +
								"\nLanguage Code: " + result.getLanguage_code() +
								"\nAverage Rating: " + result.getAverage_rating() +
								"\nRatings Count: " + result.getRatings_count() +
								"\nWork Ratings Cnt: " + result.getWork_ratings_count() +
								"\nWork Txt Reviews Cnt: " + result.getWork_text_reviews_count() + 
								"\nRatings 1: " + result.getRatings_1() +
								"\nRatings 2: " + result.getRatings_2() +
								"\nRatings 3: " + result.getRatings_3() +
								"\nRatings 4: " + result.getRatings_4() +
								"\nRatings 5: " + result.getRatings_5() + 
								"\nImage URL: " + result.getImage_url() +
								"\nSmall Image URL: " + result.getSmall_image_url() + "";
					JOptionPane.showMessageDialog(frame, displayResult);
				}
			}
		}
		if ("order".equals(e.getActionCommand())) {
			System.out.println("Order Pressed");
			
			// Gather the selected combo box item.
			String orderString = (String)comboBoxOrder.getSelectedItem();
			
			// Gather which radio button is selected.
			String selectedBtn = null;
			Enumeration<AbstractButton> allOrderRdbtn = buttonGroupOrder.getElements();
			while(allOrderRdbtn.hasMoreElements()) {
				JRadioButton temp = (JRadioButton)allOrderRdbtn.nextElement();
				if (temp.isSelected()) {
					selectedBtn = temp.getText();
					currentDirection = selectedBtn;
					currentOrder = orderString;
					
					BookTableModel newModel = new BookTableModel();
					bookListTable.setModel(newModel);
					newModel.refresh();

					System.out.println("Called.");
				}
			}
			
		}
	}

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Library Books");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add content to the window.
        frame.getContentPane().add(new GUI());

        // Display the window.
        frame.setPreferredSize(new Dimension(625, 700));
        frame.setMinimumSize(new Dimension(625, 250));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		try {
					bl = new BookLibrary(CSV_FILE_PATH);
					createAndShowGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}