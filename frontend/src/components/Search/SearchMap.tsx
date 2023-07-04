import React from 'react'
import 'leaflet/dist/leaflet.css'
import { MapContainer, TileLayer, Marker, Popup, Circle, useMapEvents } from 'react-leaflet'
import { icon } from 'leaflet'
import { ISearchRadius } from './ISearch'

const SearchMap = (props: ISearchRadius) => {

    const { radiusValue } = props;

    const ICON = icon({
        iconUrl: "/blue_pin.png",
        iconSize: [32, 32]
    })

    const handleZoomEnd = (e: any) => {
        const zoomLevel = e.target.getZoom();
        console.log('Zoom:', zoomLevel);
    };

    const MapEvents = () => {
    useMapEvents({
        zoomend: handleZoomEnd,
    });
    return null;
    };

  return (
    <MapContainer center={[37.98856735, 23.72533417]} zoom={13} maxZoom={15} scrollWheelZoom={false}
    className='h-[100%] w-[100%] z-0'
    >
        <MapEvents/>
        <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <Marker position={[37.98856735, 23.72533417]} icon={ICON}>
            <Popup>
            A pretty CSS3 popup. <br /> Easily customizable.
            </Popup>
        </Marker>
        <Circle center={[37.98856735, 23.72533417]} radius={radiusValue*1000}
        />
    </MapContainer>
  )
}

export default SearchMap