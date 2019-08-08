using System;

using System.Data;

using System.Windows.Forms;
using System.Data.SqlClient;
namespace Datakent
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            connection = new SqlConnection("Data Source=.;Initial Catalog=Datakent;Integrated Security=True");
            connection.Open();

            sqlCommand_wait = new SqlCommand();
            sqlCommand_wait.CommandText = "select * from Data WHERE CONVERT(VARCHAR, kontrol) ='not checked'";
            sqlCommand_wait.Connection = connection;

            sqlCommand_checked = new SqlCommand();
            sqlCommand_checked.CommandText="select * from Data WHERE CONVERT(VARCHAR, kontrol) ='checked'";
            sqlCommand_checked.Connection = connection;

            sqlDataAdapter_wait = new SqlDataAdapter(sqlCommand_wait);
            sqlDataAdapter_checked = new SqlDataAdapter(sqlCommand_checked);

            dataTable_wait = new DataTable();
            sqlDataAdapter_wait.Fill(dataTable_wait);
            dataGridView1.DataSource = dataTable_wait;

            dataTable_checked = new DataTable();
            sqlDataAdapter_checked.Fill(dataTable_checked);
            dataGridView2.DataSource = dataTable_checked;

            buttonColumn = new DataGridViewButtonColumn();
            buttonColumn.HeaderText = "Onayla";
            buttonColumn.Name = "buttonColumn";
            buttonColumn.Text = "Onayla";
            buttonColumn.UseColumnTextForButtonValue = true;
            dataGridView1.Columns.Add(buttonColumn);

        }
        SqlConnection 
            connection;
        SqlCommand
            sqlCommand_wait,sqlCommand_checked,sqlCommand_set_checked;
        SqlDataAdapter 
            sqlDataAdapter_wait,sqlDataAdapter_checked;
        DataTable 
            dataTable_wait,dataTable_checked;

        private void Yenile_Click(object sender, EventArgs e)
        {
            update_loads();
        }

        DataGridViewButtonColumn
buttonColumn;

        private void DataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            String id = dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();

            String check = "checked";
            if (e.ColumnIndex.Equals(0))
            {
                sqlCommand_set_checked = connection.CreateCommand();
                sqlCommand_set_checked.CommandText = "Update Data set kontrol = '" + check + "' where data_id = " + id;
                sqlCommand_set_checked.ExecuteNonQuery();
                update_loads();
            }

        }
        public void update_loads()
        {
            dataTable_wait = new DataTable();
            sqlDataAdapter_wait.Fill(dataTable_wait);
            dataGridView1.DataSource = dataTable_wait;
            dataTable_checked = new DataTable();
            sqlDataAdapter_checked.Fill(dataTable_checked);
            dataGridView2.DataSource = dataTable_checked;
        }
    }
    
}
