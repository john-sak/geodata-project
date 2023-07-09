import React, { useState, useEffect } from "react";
import axios from "axios";
import { axiosPrivate } from "@/api/axios";

interface Favorite {
  id: number;
  latitude: number;
  longitude: number;
  distance: number;
}

const Favorites = () => {
  const [favorites, setFavorites] = useState<Favorite[]>([]);
  const [favoritesCount, setFavoritesCount] = useState(0);

  useEffect(() => {
    
    // Send a GET request to retrieve user favorites
    const fetchFavorites = async () => {

      const accessToken = localStorage.getItem('access_token');
      
      try {
        const response = await axiosPrivate.get("https://localhost:8080/api/aoi/mine", {
          headers: {
            Authorization: `Bearer ${accessToken}`, // Include the access token in the headers
          },
        });

        setFavorites(response.data);
        setFavoritesCount(response.data.length); // Set the count of favorites
      } 
      catch (error) {
        console.error("Error fetching favorites:", error);
      }
    };

    fetchFavorites();
  }, []);

  return (
    <div className="bg-white p-4 shadow">
      <h2 className="text-xl font-bold mb-2">Αγαπημένα - Περιοχές ενδιαφέροντος</h2>
      <p className="mb-4">Έχετε θέσει <span className="text-green-600">{favoritesCount}</span> περιοχές ενδιαφέροντος:</p>
      {favorites.length === 0 ? (
        <p className="mt-4 text-teal-700">Δεν έχετε θέσει ακόμα αγαπημένα. Θα εμφανίζονται εδώ αφού τα θέσετε μέσω της εφαρμογής.</p>
      ) : (
        <div className="flex flex-wrap">
        {favorites.map((favorite, index) => (
          <div key={favorite.id} className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 xl:w-1/5 p-2">
            <div className="bg-gray-200 p-2 rounded">
              <p className="text-center mb-2">Περιοχή ενδιαφέροντος {index + 1}</p>
              <p>Longitude σημείου: <span className="text-purple-500">{favorite.longitude}</span></p>
              <p>Latitude σημείου: <span className="text-purple-500">{favorite.latitude}</span></p>
              <p>Απόσταση από σημείο: <span className="text-purple-500">{favorite.distance}</span> χλμ.</p>
            </div>
          </div>
        ))}
      </div>
      )}
    </div>
  );
};

export default Favorites;