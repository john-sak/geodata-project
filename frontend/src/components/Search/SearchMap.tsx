import React from 'react'
import 'leaflet/dist/leaflet.css'
import { MapContainer, TileLayer, Marker, Popup, Circle, useMapEvents } from 'react-leaflet'
import { icon } from 'leaflet'
import { ISearchMap } from './ISearch'

const SearchMap = (props: ISearchMap) => {

    const { search, results } = props;
    const {
        selectedName,
        setSelectedName,
        numbers,
        setNumbers
    } = search;

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
    <MapContainer center={[numbers.lat, numbers.lon]} zoom={13} maxZoom={15} scrollWheelZoom={false}
    className='h-[100%] w-[100%] z-0'
    >
        <MapEvents/>
        <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        {
            results.length !== 0 &&
            results.map((value) => {
                return(
                    <Marker key={value.id} position={[value.latitude, value.longitude]} icon={ICON}
                    eventHandlers={{click: (e) => {setSelectedName(value.name)}}}
                    >
                        {
                            value.description &&
                            <Popup>
                                {value.description}
                            </Popup>
                        }
                    </Marker>
                )
            })
        }
        <Circle center={[numbers.lat, numbers.lon]} radius={numbers.radius*1000}
        />
    </MapContainer>
  )
}

export default SearchMap