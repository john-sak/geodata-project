import React from 'react'
import 'leaflet/dist/leaflet.css'
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import { icon } from 'leaflet'

const SearchMap = () => {

    const ICON = icon({
        iconUrl: "/blue_pin.png",
        iconSize: [32, 32]
    })

  return (
    <MapContainer center={[37.98856735, 23.72533417]} zoom={13} scrollWheelZoom={false}
    className='h-[100%] w-[100%] z-0'
    >
        <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <Marker position={[37.98856735, 23.72533417]} icon={ICON}>
            <Popup>
            A pretty CSS3 popup. <br /> Easily customizable.
            </Popup>
        </Marker>
    </MapContainer>
  )
}

export default SearchMap