import React, { useState } from "react";
import ExitButton from "../components/ExitButton";
import {
  Box,
  Typography,
  Grid,
  Card,
  CardContent,
  LinearProgress,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  SelectChangeEvent,
  Avatar,
  Paper
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
    photo: "https://www.w3schools.com/w3images/avatar2.png", // URL de la foto
    institute: "Instituto Secundario XYZ", // Nuevo campo: Instituto de origen
    hometown: "Madrid, España", // Nuevo campo: Ciudad de origen
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
    <Box sx={{ p: 3, backgroundColor: "#121212", minHeight: "100vh" }}>
      <ExitButton />
      
      {/* Carnet Estudiantil */}
      <Box
        sx={{
          backgroundColor: "rgba(0, 0, 0, 0.8)",
          border: "2px solid #F26F63", // Borde rojo
          borderRadius: "10px",
          padding: 3,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          maxWidth: 300,
          margin: "auto",
          boxShadow: 3,
        }}
      >
        {/* Foto del estudiante */}
        <Avatar
          alt={studentData.name}
          src={studentData.photo}
          sx={{
            width: 100,
            height: 100,
            border: "4px solid #F26F63",
            marginBottom: 2,
          }}
        />
        
        {/* Nombre del estudiante */}
        <Typography variant="h5" color="white" gutterBottom>
          {studentData.name}
        </Typography>
        <Typography variant="subtitle1" color="white">
          Estudiante
        </Typography>

        {/* Información adicional */}
        <Typography variant="body2" color="white" sx={{ mt: 1 }}>
          {studentData.institute}
        </Typography>
        <Typography variant="body2" color="white">
          {studentData.hometown}
        </Typography>
      </Box>

      <Grid container spacing={3} justifyContent="center">
        <Grid item xs={12} md={3}>
          <Card
            elevation={3}
            sx={{
              backgroundColor: "rgba(0, 0, 0, 0.7)",
              border: "2px solid #F26F63", // Rojo personalizado
              borderRadius: "10px", // Bordes redondeados
            }}
          >
            <CardContent>
              <Typography variant="h6" gutterBottom color="white">
                Asistencia
              </Typography>
              <Typography variant="h4" color="primary" gutterBottom>
                {studentData.attendance}%
              </Typography>
              <LinearProgress
                variant="determinate"
                value={studentData.attendance}
                sx={{
                  height: 10,
                  borderRadius: 5,
                  backgroundColor: "rgba(255, 255, 255, 0.2)",
                  "& .MuiLinearProgress-bar": {
                    backgroundColor: "#F26F63", // Rojo personalizado
                  },
                }}
              />
            </CardContent>
          </Card>
        </Grid>

        <Grid item xs={12} md={3}>
          <Card
            elevation={3}
            sx={{
              backgroundColor: "rgba(0, 0, 0, 0.7)",
              border: "2px solid #F26F63", // Rojo personalizado
              borderRadius: "10px", // Bordes redondeados
            }}
          >
            <CardContent>
              <Typography variant="h6" gutterBottom color="white">
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

        <Grid item xs={12} md={3}>
          <Card
            elevation={3}
            sx={{
              backgroundColor: "rgba(0, 0, 0, 0.7)",
              border: "2px solid #F26F63", // Rojo personalizado
              borderRadius: "10px", // Bordes redondeados
            }}
          >
            <CardContent>
              <Typography variant="h6" gutterBottom color="white">
                Trayectoria Académica
              </Typography>
              <ul>
                {studentData.trajectory.map((step, index) => (
                  <li key={index}>
                    <Typography color="white">{step}</Typography>
                  </li>
                ))}
              </ul>
            </CardContent>
          </Card>
        </Grid>
      </Grid>

      <Box sx={{ mt: 4 }}>
        <Typography variant="h5" gutterBottom color="white">
          Selección de Centros Educativos
        </Typography>
        <FormControl fullWidth sx={{ mt: 2 }}>
          <InputLabel sx={{ color: "white" }}>Selecciona un centro</InputLabel>
          <Select
            value={selectedCenter}
            onChange={handleSelectCenter}
            label="Selecciona un centro"
            sx={{
              backgroundColor: "rgba(255, 255, 255, 0.1)",
              color: "white",
              border: "2px solid #F26F63", // Rojo personalizado
            }}
          >
            {educationalCenters.map((center, index) => (
              <MenuItem key={index} value={center} sx={{ color: "black" }}>
                {center}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        {selectedCenter && (
          <Typography variant="h6" sx={{ mt: 2, color: "white" }}>
            Has seleccionado: {selectedCenter}
          </Typography>
        )}
      </Box>
    </Box>
  );
};

export default StudentDashboard;
