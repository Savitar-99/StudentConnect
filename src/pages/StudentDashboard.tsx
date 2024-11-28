import React from "react";
import {
  Box,
  Typography,
  Grid,
  Card,
  CardContent,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  LinearProgress,
} from "@mui/material";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

const StudentDashboard = () => {
  // Simulación de datos del estudiante
  const studentData = {
    name: "David Johnson",
    attendance: 85,
    grades: [
      { subject: "Matemáticas", grade: 90 },
      { subject: "Historia", grade: 78 },
      { subject: "Ciencias", grade: 88 },
      { subject: "Inglés", grade: 85 },
    ],
    trajectory: ["Escuela Primaria", "Instituto Secundario", "Universidad ABC"],
  };

  // Datos para el gráfico
  const chartData = studentData.grades.map((grade) => ({
    name: grade.subject,
    Calificación: grade.grade,
  }));

  return (
    <Box sx={{ p: 3, backgroundColor: "#f9f9f9", minHeight: "100vh" }}>
      {/* Bienvenida */}
      <Typography variant="h4" component="h1" gutterBottom>
        Bienvenido, {studentData.name}
      </Typography>

      <Grid container spacing={3}>
        {/* Tarjeta de asistencia */}
        <Grid item xs={12} md={4}>
          <Card elevation={3}>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Asistencia
              </Typography>
              <Typography variant="h4" color="primary" gutterBottom>
                {studentData.attendance}%
              </Typography>
              <LinearProgress
                variant="determinate"
                value={studentData.attendance}
                sx={{ height: 10, borderRadius: 5 }}
              />
            </CardContent>
          </Card>
        </Grid>

        {/* Tarjeta de promedio */}
        <Grid item xs={12} md={4}>
          <Card elevation={3}>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Promedio General
              </Typography>
              <Typography variant="h4" color="secondary" gutterBottom>
                {(
                  studentData.grades.reduce((sum, g) => sum + g.grade, 0) /
                  studentData.grades.length
                ).toFixed(1)}
              </Typography>
            </CardContent>
          </Card>
        </Grid>

        {/* Trayectoria académica */}
        <Grid item xs={12} md={4}>
          <Card elevation={3}>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Trayectoria Académica
              </Typography>
              <ul>
                {studentData.trajectory.map((step, index) => (
                  <li key={index}>
                    <Typography>{step}</Typography>
                  </li>
                ))}
              </ul>
            </CardContent>
          </Card>
        </Grid>
      </Grid>

      {/* Gráfico de rendimiento */}
      <Box sx={{ mt: 4 }}>
        <Typography variant="h5" gutterBottom>
          Rendimiento Académico
        </Typography>
        <Card elevation={3}>
          <CardContent>
            <ResponsiveContainer width="100%" height={300}>
              <LineChart data={chartData}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis />
                <Tooltip />
                <Line
                  type="monotone"
                  dataKey="Calificación"
                  stroke="#8884d8"
                  strokeWidth={2}
                  activeDot={{ r: 8 }}
                />
              </LineChart>
            </ResponsiveContainer>
          </CardContent>
        </Card>
      </Box>

      {/* Tabla de calificaciones */}
      <Box sx={{ mt: 4 }}>
        <Typography variant="h5" gutterBottom>
          Tus Notas
        </Typography>
        <TableContainer component={Paper} elevation={3}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Asignatura</TableCell>
                <TableCell align="right">Calificación</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {studentData.grades.map((row, index) => (
                <TableRow key={index}>
                  <TableCell>{row.subject}</TableCell>
                  <TableCell align="right">{row.grade}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    </Box>
  );
};

export default StudentDashboard;
