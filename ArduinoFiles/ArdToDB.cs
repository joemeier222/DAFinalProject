using System;
using MySql.Data.MySqlClient;
using System.IO.Ports;


namespace sql_test
{
    class Program
    {
        static void Main()
        {
            SerialPort ardPort = new SerialPort("COM11", 9600);
            ardPort.Open();
            MySqlConnection conn = new MySqlConnection("server=iss.cpstbqrsbadl.us-west-1.rds.amazonaws.com;"
                + "user=admin;database=iss;port=3306;password=is!12345");
            while (true)
            {
                CallSql(conn, ardPort);

            }
        }

        static void CallSql(MySqlConnection conn, SerialPort ardPort)
        {
            try
            {
                    conn.Open();
                    string sql;
                    MySqlCommand cmd;
                    ardPort.ReadLine();
                    string line = ardPort.ReadLine();
                    string[] words = line.Split(' ');
                    decimal humidity = Convert.ToDecimal(words[0]);
                    decimal temp = Convert.ToDecimal(words[1]);
                    decimal heatIndex = Convert.ToDecimal(words[2]);
                    int sensorOne = Convert.ToInt32(words[3]);
                    int sensorTwo = Convert.ToInt32(words[4]);
                    DateTime dt = DateTime.Now;
                    sql = "INSERT INTO iss.data (Id, Humidity, Temperature, HeatIndex, SensorOne, SensorTwo, DateTime,Username) VALUES" +
                        "(NULL, " + humidity + "," + temp + "," + heatIndex + ","
                        + sensorOne + "," + sensorTwo + ",'" + dt.ToString("yyyy-MM-dd HH:mm:ss") + "','user3');";
                    Console.WriteLine(sql);
                    cmd = new MySqlCommand(sql, conn);
                    cmd.ExecuteNonQuery();
                    conn.Close();  
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
        }
    }
}
