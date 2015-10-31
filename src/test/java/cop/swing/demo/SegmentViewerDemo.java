package cop.swing.demo;

import cop.swing.controls.layouts.SingleColumnLayout;
import cop.swing.controls.layouts.SingleRowLayout;
import cop.swing.controls.segment.SegmentViewer;
import cop.swing.controls.segment.groups.numeric.ByteSegment;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Oleg Cherednik
 * @since 18.07.2015
 */
public class SegmentViewerDemo extends JFrame implements ActionListener {
    private final SegmentViewer<Byte> segmentViewer = new SegmentViewer<>();
    private final SettingsPanel settingsPanel = new SettingsPanel(segmentViewer);

    public SegmentViewerDemo() {
        init();
    }

    private void init() {
        segmentViewer.setContainer(ByteSegment.create());
        segmentViewer.setBackground(Color.black);
        segmentViewer.setScale(2);
        segmentViewer.setValue((byte)0);
//        sectionViewer.setLayoutOrganizer(SettingsPanel.SINGLE_COLUMN);
        setLayout(new BorderLayout(5, 5));

        add(settingsPanel, BorderLayout.EAST);
        add(segmentViewer, BorderLayout.CENTER);

//        segmentViewer.setBorder(BorderFactory.createEtchedBorder());
        segmentViewer.setBackground(Color.black);

        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // ========== ActionListener ==========

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    // ========== static ==========

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SegmentViewerDemo().setVisible(true);
            }
        });
    }

    // ========== classes ==========

    static class SettingsPanel extends JPanel implements ActionListener, ChangeListener {
        private static final long serialVersionUID = -7738468553704362158L;
        private static final SingleColumnLayout SINGLE_COLUMN = new SingleColumnLayout();
        private static final SingleRowLayout SINGLE_ROW = new SingleRowLayout();

        private int id = 1;

        private final SegmentViewer<Byte> segmentViewer;
        private final JButton addSection = new JButton("Add section");
        private final JButton addGlue = new JButton("Add glue");
        private final JButton addTextField0 = new JButton("Add text field (col=0)");
        private final JButton addTextField1 = new JButton("Add text field (col=10)");
        private final JButton removeLast = new JButton("Remove last");
        private final JButton changeBackground = new JButton("Change background");
        private final JButton columnStrategy = new JButton("Column");
        private final JButton rowStrategy = new JButton("Row");
        private final JSpinner valueSpinner = new JSpinner(new SpinnerNumberModel(0, Byte.MIN_VALUE, Byte.MAX_VALUE, 1));
        private final JComboBox<Alignment> alignmentCombo = new JComboBox<>();

        private final Random rand = new Random();

        public SettingsPanel(SegmentViewer<Byte> segmentViewer) {
            this.segmentViewer = segmentViewer;

            init();
            addListeners();
        }

        private void init() {
            setLayout(new GridBagLayout());

            for (Alignment alignment : Alignment.values())
                alignmentCombo.addItem(alignment);

            GridBagConstraints gbc = createConstraints();

            add(addSection, gbc);
            add(addGlue, gbc);
            add(addTextField0, gbc);
            add(addTextField1, gbc);
            add(removeLast, gbc);
            add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
            add(changeBackground, gbc);
            add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
            add(columnStrategy, gbc);
            add(rowStrategy, gbc);
            add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

            gbc.gridwidth = 1;
            add(new JLabel("space: "), gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(valueSpinner, gbc);
            gbc.gridwidth = 1;
            add(new JLabel("alignment: "), gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(alignmentCombo, gbc);

            add(new JSeparator(SwingConstants.HORIZONTAL), gbc);

            gbc.weighty = 1;
            add(Box.createVerticalGlue(), gbc);
        }

        private void addListeners() {
            addSection.addActionListener(this);
            addGlue.addActionListener(this);
            addTextField0.addActionListener(this);
            addTextField1.addActionListener(this);
            removeLast.addActionListener(this);
            changeBackground.addActionListener(this);
            columnStrategy.addActionListener(this);
            rowStrategy.addActionListener(this);
            valueSpinner.addChangeListener(this);
            alignmentCombo.addActionListener(this);
        }

        // ========== ActionListener ==========

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == addSection) {
//                LocalSection section = new LocalSection(id++);
//                sectionViewer.addSection(section);
            } else if (event.getSource() == addGlue) {
//                panel.addComp(panel.getLayoutOrganizer() == SINGLE_COLUMN ? Box.createVerticalGlue() : Box.createHorizontalGlue());
            } else if (event.getSource() == addTextField0) {
//                for(Component component : sectionViewer.getSections())
//                    System.out.println(String.format("%s: [%d;%d] w:%d h:%d", component, component.getX(), component.getY(), component.getWidth(), component.getHeight()));
//                System.out.println();
//                panel.addComp(new JTextField("This is a text field"));
            } else if (event.getSource() == addTextField1) {
//                JTextField textField = new JTextField(10);
//                textField.setText("Text field with 10 columns");
//                panel.addComp(textField);
            } else if (event.getSource() == removeLast) {
//                int total = sectionViewer.getSectionsAmount();
//
//                if (total > 0) {
//                    LocalSection section = sectionViewer.getSections().get(total - 1);
//                    sectionViewer.removeSection(section);
//                }
            } else if (event.getSource() == changeBackground)
                segmentViewer.setBackground(new Color(rand.nextInt(0xFFFFFF)));
//            else if (event.getSource() == columnStrategy)
//                sectionViewer.setLayoutOrganizer(SINGLE_COLUMN);
//            else if (event.getSource() == rowStrategy)
//                sectionViewer.setLayoutOrganizer(SINGLE_ROW);
//            else if (event.getSource() == alignmentCombo) {
//                Alignment alignment = (Alignment)alignmentCombo.getSelectedItem();
//                SINGLE_COLUMN.setAlignment(alignment.value);
//                SINGLE_ROW.setAlignment(alignment.value);
//                sectionViewer.updateUI();
//            }
        }

        // ========== ChangeListener ==========

        @Override
        public void stateChanged(ChangeEvent event) {
            if (event.getSource() == valueSpinner) {
                int value = (Integer)valueSpinner.getValue();
                segmentViewer.setValue((byte)value);
//                sectionViewer.updateUI();
            }
        }

        // ========== static ==========

        private static GridBagConstraints createConstraints() {
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;

            return gbc;
        }

        // ========== enum ==========

        private enum Alignment {
            CENTER("Center", SwingConstants.CENTER),
            NORTH("North", SwingConstants.NORTH),
            SOUTH("South", SwingConstants.SOUTH),
            WEST("West", SwingConstants.WEST),
            EAST("East", SwingConstants.EAST),
            LEADING("Leading", SwingConstants.LEADING),
            TRAILING("Trailing", SwingConstants.TRAILING);

            private final String title;
            public final int value;

            Alignment(String title, int value) {
                this.title = title;
                this.value = value;
            }

            // ========== Object ==========

            @Override
            public String toString() {
                return title;
            }
        }
    }
}
