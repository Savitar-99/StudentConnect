import React, { useState, useEffect } from "react";
import axios from "axios";
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
  Button,
  LinearProgress,
} from "@mui/material";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ResponsiveContainer,
} from "recharts";

// Definir tipo de estudiante
type Student = {
  id: number;
  name: string;
  attendance: number;
  grade: number;
  attitude?: string;
  comments?: string;
};

const TeacherDashboard = () => {
  const [students, setStudents] = useState<Student[]>([]);
  const [loading, setLoading] = useState(true);

  // Obtener datos de la API
  useEffect(() => {
    const fetchStudents = async () => {
      try {
        const response = await axios.get("http://localhost:3000/students");
        setStudents(response.data);
      } catch (error) {
        console.error("Error al obtener los datos:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchStudents();
  }, []);

  // Datos para el gráfico
  const chartData = students.map((student) => ({
    name: student.name,
    Calificación: student.grade,
    Asistencia: student.attendance,
  }));

  if (loading) {
    return (
      <Box sx={{ display: "flex", justifyContent: "center", mt: 5 }}>
        <Typography variant="h6">Cargando datos...</Typography>
      </Box>
    );
  }

  return (
    <Box sx={{ p: 3, backgroundColor: "#f9f9f9", minHeight: "100vh" }}>
      <Typography variant="h4" component="h1" gutterBottom>
        Panel del Profesor
      </Typography>

      {/* Tarjetas de resumen */}
      <Grid container spacing={3}>
        <Grid item xs={12} md={4}>
          <Card elevation={3} sx={{ backgroundColor: "#e3f2fd" }}>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Total de Estudiantes
              </Typography>
              <Typography variant="h4" color="primary">
                {students.length}
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      </Grid>

      {/* Tabla de estudiantes */}
      <TableContainer component={Paper} sx={{ mt: 4 }}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Nombre</TableCell>
              <TableCell align="center">Asistencia</TableCell>
              <TableCell align="center">Calificación</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {students.map((student) => (
              <TableRow key={student.id}>
                <TableCell>{student.name}</TableCell>
                <TableCell align="center">
                  <LinearProgress
                    variant="determinate"
                    value={student.attendance}
                    sx={{ height: 10, borderRadius: 5 }}
                  />
                  <Typography variant="body2">{student.attendance}%</Typography>
                </TableCell>
                <TableCell align="center">{student.grade}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      {/* Gráfico */}
      <Box sx={{ mt: 4 }}>
        <Typography variant="h5" gutterBottom>
          Tendencias de Estudiantes
        </Typography>
        <ResponsiveContainer width="100%" height={300}>
          <BarChart data={chartData}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="name" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Bar dataKey="Calificación" fill="#8884d8" />
            <Bar dataKey="Asistencia" fill="#82ca9d" />
          </BarChart>
        </ResponsiveContainer>
      </Box>
    </Box>
  );
};

export default TeacherDashboard;
