import React, { useState } from "react";
import ExitButton from "../components/ExitButton";
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
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  SelectChangeEvent,
} from "@mui/material";

const StudentDashboard = () => {
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

  const educationalCenters = [
    "Universidad ABC",
    "Instituto de Ciencias XYZ",
    "Escuela Técnica Delta",
    "Universidad de Tecnología Lambda",
  ];

  const [selectedCenter, setSelectedCenter] = useState("");

  const handleSelectCenter = (event: SelectChangeEvent<string>) => {
    setSelectedCenter(event.target.value);
  };

  return (
    <Box sx={{ p: 3, backgroundColor: "#f9f9f9", minHeight: "100vh" }}>
      <ExitButton />
      <Typography variant="h4" component="h1" gutterBottom>
        Bienvenido, {studentData.name}
      </Typography>

      <Grid container spacing={3}>
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

      <Box sx={{ mt: 4 }}>
        <Typography variant="h5" gutterBottom>
          Selección de Centros Educativos
        </Typography>
        <FormControl fullWidth sx={{ mt: 2 }}>
          <InputLabel>Selecciona un centro</InputLabel>
          <Select
            value={selectedCenter}
            onChange={handleSelectCenter}
            label="Selecciona un centro"
          >
            {educationalCenters.map((center, index) => (
              <MenuItem key={index} value={center}>
                {center}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        {selectedCenter && (
          <Typography variant="h6" sx={{ mt: 2 }}>
            Has seleccionado: {selectedCenter}
          </Typography>
        )}
      </Box>
    </Box>
  );
};

export default StudentDashboard;
