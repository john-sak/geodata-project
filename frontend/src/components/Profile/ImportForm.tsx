import React, { useState } from 'react';
import axios from 'axios';

const ImportForm = () => {
  const [selectedFile, setSelectedFile] = useState<File | null>(null);
  const [importSuccess, setImportSuccess] = useState(false);

  const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    if (event.target.files && event.target.files.length > 0) {
      setSelectedFile(event.target.files[0]);
    }
  };

  const handleDragOver = (event: React.DragEvent<HTMLDivElement>) => {
    event.preventDefault();
    event.stopPropagation();
  };

  const handleDrop = (event: React.DragEvent<HTMLDivElement>) => {
    event.preventDefault();
    event.stopPropagation();

    if (event.dataTransfer && event.dataTransfer.files && event.dataTransfer.files.length > 0) {
      setSelectedFile(event.dataTransfer.files[0]);
    }
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    if (!selectedFile) {
      // No file selected, handle the error
      console.error('No file selected');
      return;
    }

    const accessToken = localStorage.getItem('access_token');

    // Create a FormData object to send the file
    const formData = new FormData();
    formData.append('file', selectedFile);

    try {
      // Make the API call to import the file
      await axios.post('http://localhost:8080/api/poi/import', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: `Bearer ${accessToken}`, // Include the access token in the headers
        },
      });
  
      // Handle success and display a success message
      console.log('File imported successfully');
      setImportSuccess(true);
      setSelectedFile(null); // Reset the selected file state
    } catch (error) {
      // Handle error and display an error message
      console.error('Error importing file:', error);
    }
  };

  return (
    <div className="bg-white p-4 shadow" onDragOver={handleDragOver} onDrop={handleDrop}>
      <h2 className="text-xl font-bold mb-10">Εισαγωγή νέου csv αρχείου</h2>
       <form onSubmit={handleSubmit}>
        <input type="file" title=" " onChange={handleFileChange} />
        <p className="text-xl my-8"> OR </p>
        <div className="bg-gray-300 text-lg border border-black shadow rounded w-1/2 h-32 flex items-center justify-center" onDragOver={handleDragOver} onDrop={handleDrop} >
          {selectedFile ? (
            <p>
              Selected file: <span className="text-blue-600">{selectedFile.name}</span>
            </p>
          ) : (
            <p>Drag and drop your file here</p>
          )}
        </div>
        <button type="submit" className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-1 px-4 mt-3 rounded">Upload</button>
      </form>
      {importSuccess && <p className="text-green-500">File imported successfully</p>}
    </div>
  );
};

export default ImportForm;