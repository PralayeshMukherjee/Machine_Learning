import React, { useState } from "react";
import axios from "axios";
import { motion } from "framer-motion";

function Predictor() {
  const [iq, setIq] = useState("");
  const [cgpa, setCgpa] = useState("");
  const [prediction, setPrediction] = useState(null);
  const [loading, setLoading] = useState(false);

  const handlePredict = async () => {
    if (!iq || !cgpa) {
      alert("Please enter both IQ and CGPA!");
      return;
    }
    setLoading(true);
    try {
      const res = await axios.post("http://localhost:8080/api/prediction", {
        iq: parseFloat(iq),
        cgpa: parseFloat(cgpa),
      });
      const data =
        typeof res.data === "string" ? JSON.parse(res.data) : res.data;
      setPrediction(data.prediction);
    } catch (error) {
      console.error("Error fetching prediction:", error);
      alert("Something went wrong. Try again!");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="flex justify-center items-center min-h-screen bg-gradient-to-br from-blue-100 via-white to-blue-50">
      <motion.div
        className="bg-white p-8 rounded-2xl shadow-2xl w-full max-w-md text-center"
        initial={{ opacity: 0, y: 40 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.5 }}
      >
        <h2 className="text-2xl font-bold mb-6 text-blue-600">
          🎯 IQ-CGPA Predictor
        </h2>

        <input
          type="number"
          placeholder="Enter IQ"
          value={iq}
          onChange={(e) => setIq(e.target.value)}
          className="w-full px-4 py-2 mb-4 border rounded-xl focus:ring-2 focus:ring-blue-400 outline-none transition"
        />

        <input
          type="number"
          placeholder="Enter CGPA"
          value={cgpa}
          onChange={(e) => setCgpa(e.target.value)}
          className="w-full px-4 py-2 mb-6 border rounded-xl focus:ring-2 focus:ring-blue-400 outline-none transition"
        />

        <button
          onClick={handlePredict}
          disabled={loading}
          className={`w-full py-2 rounded-xl text-white font-semibold transition ${
            loading
              ? "bg-blue-300 cursor-not-allowed"
              : "bg-blue-500 hover:bg-blue-600"
          }`}
        >
          {loading ? "Predicting..." : "Predict"}
        </button>

        {prediction !== null && (
          <motion.p
            className="mt-6 text-lg font-medium text-gray-700"
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            transition={{ duration: 0.4 }}
          >
            <strong>Prediction:</strong>{" "}
            <span className="text-blue-600">{prediction}</span>
          </motion.p>
        )}
      </motion.div>
    </div>
  );
}

export default Predictor;
