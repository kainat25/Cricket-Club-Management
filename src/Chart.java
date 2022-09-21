import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Chart{
    JFrame fa;
    JButton b1;
    public Chart() {
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///project61","root","");
            DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
            Statement stmt = conn.createStatement();

            ResultSet query_set = stmt.executeQuery("select name,matchplay,run,wicket,hundred,four from performance where name='Alrounder hamad'");
            while (query_set.next()) {
                String name= query_set.getString("name");
                int matchplay = query_set.getInt("matchplay");
                int run = query_set.getInt("run");
                int wicket = query_set.getInt("wicket");
                int hundred = query_set.getInt("hundred");
                int four= query_set.getInt("four");

                my_bar_chart_dataset.addValue(matchplay, name,"matchplay");
                my_bar_chart_dataset.addValue(run,name,"run");
                my_bar_chart_dataset.addValue(wicket, name,"wicket");
                my_bar_chart_dataset.addValue(hundred, name,"hundred");
                my_bar_chart_dataset.addValue(four, name,"four");
            }
            JFreeChart BarChartObject=ChartFactory.createBarChart("Player progress chart","performance category","level",my_bar_chart_dataset,PlotOrientation.VERTICAL,true,true,true);
            query_set.close();
            stmt.close();
            conn.close();

            fa=new JFrame("performance graph");
            fa.setBounds(0,0,700,600);
            fa.setLocationRelativeTo(null);
            
            ChartPanel p=new ChartPanel(BarChartObject);
            p.setBounds(100,100,400,300);
            fa.add(p);
            fa.setVisible(true);
        }

        catch (Exception i)
        {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        Chart c=new Chart();

    }
    }
