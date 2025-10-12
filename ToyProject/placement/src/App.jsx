import React, { useState } from "react";
import axios from "axios";

function Predictor() {
  const [iq, setIq] = useState("");
  const [cgpa, setCgpa] = useState("");
  const [prediction, setPrediction] = useState(null);

  const handlePredict = async () => {
    try {
      const res = await axios.post("http://localhost:8080/api/prediction", {
        iq: parseFloat(iq),
        cgpa: parseFloat(cgpa),
      });
      const data = typeof res.data === "string" ? JSON.parse(res.data) : res.data;
      setPrediction(data.prediction);
    } catch (error) {
      console.error("Error fetching prediction:", error);
    }
  };

  return (
    <div style={{ margin: "50px", textAlign: "center" }}>
      <h2>IQ-CGPA Prediction</h2>
      <input
        type="number"
        placeholder="Enter IQ"
        value={iq}
        onChange={(e) => setIq(e.target.value)}
      />
      <br /><br />
      <input
        type="number"
        placeholder="Enter CGPA"
        value={cgpa}
        onChange={(e) => setCgpa(e.target.value)}
      />
      <br /><br />
      <button onClick={handlePredict}>Predict</button>
      {prediction !== null && (
        <p style={{ marginTop: "20px" }}>
          <strong>Prediction:</strong> {prediction}
        </p>
      )}
    </div>
  );
}

export default Predictor;
