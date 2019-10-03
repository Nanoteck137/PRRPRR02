using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Calc
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string[,] buttonNames =
        {
            { "1", "2", "3", "+" },
            { "4", "5", "6", "-" },
            { "7", "8", "9", "/" },
            { "C", "0", "=", "*" },
        };

        private Dictionary<string, RoutedEventHandler> customClick;

        private TextBox textBox;

        public MainWindow()
        {
            InitializeComponent();

            customClick = new Dictionary<string, RoutedEventHandler>();

            customClick.Add("=", Equal_Click);

            this.grid.ColumnDefinitions.Add(new ColumnDefinition());
            this.grid.ColumnDefinitions.Add(new ColumnDefinition());
            this.grid.ColumnDefinitions.Add(new ColumnDefinition());
            this.grid.ColumnDefinitions.Add(new ColumnDefinition());

            this.grid.RowDefinitions.Add(new RowDefinition());
            this.grid.RowDefinitions.Add(new RowDefinition());
            this.grid.RowDefinitions.Add(new RowDefinition());
            this.grid.RowDefinitions.Add(new RowDefinition());
            this.grid.RowDefinitions.Add(new RowDefinition());

            int rowOffset = 0;

            textBox = new TextBox
            {
                FontSize = 20,
                TextAlignment = TextAlignment.Right,
                Margin = new Thickness(5.0, 20.0, 5.0, 30.0),
                Padding = new Thickness(2.0, 5.0, 2.0, 5.0),
                TextWrapping = TextWrapping.NoWrap,
                AcceptsReturn = false,
                VerticalAlignment = VerticalAlignment.Center
            };
            Grid.SetRow(textBox, 0);
            Grid.SetColumnSpan(textBox, 4);
            this.grid.Children.Add(textBox);
            rowOffset++;

            for (int y = 0; y < buttonNames.GetLength(1); y++)
            {
                for (int x = 0; x < buttonNames.GetLength(0); x++)
                {
                    string name = buttonNames[y, x];
                    Button button = new Button()
                    {
                        Content = name,
                    };

                    if (customClick.ContainsKey(name))
                    {
                        button.Click += customClick[name];
                    }
                    else
                    {
                        button.Click += this.Button_Click;
                    }

                    Grid.SetColumn(button, x);
                    Grid.SetRow(button, y + rowOffset);

                    this.grid.Children.Add(button);
                }
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button button = (Button)sender;
            textBox.Text += button.Content;
        }

        private void Equal_Click(object sender, RoutedEventArgs e)
        {
            string input = textBox.Text;
            string output = new DataTable().Compute(input, null).ToString();
            textBox.Text = output;
        }
    }
}
