import React,{useState, useEffect} from 'react'
import 'leaflet/dist/leaflet.css'
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import { icon } from 'leaflet'
import useSWR from 'swr'

const fetcher = async () => fetch('https://randomuser.me/api/').then((res) => res.json())

const DummyComponent = () => {

    const ICON = icon({
        iconUrl: "/marker.png",
        iconSize: [32, 32]
    })

    const [someEmail, setSomeEmail] = useState([]);

    useEffect(() => {
        fetch('https://randomuser.me/api/')
        .then((response) => response.json())
        .then((data) => setSomeEmail(data.results[0].email))
        .catch((error) => console.error(error))
    }, [])


    const {data, error} = useSWR('https://randomuser.me/api/', fetcher);
    const [swrEmail, setSwrEmail] = useState([]);
    useEffect(() => {
        data && setSwrEmail(data.results[0].email);
    }, [data])

  return (
    <>
        {
         someEmail && <p>
            UseEffect normal fetch {someEmail}
        </p>
        }
        {
         swrEmail && <p>
            useSWR hook {swrEmail}
        </p>
        }
        <MapContainer center={[51.505, -0.09]} zoom={13} scrollWheelZoom={false}
        className='h-[1000px] w-[1000px]'
        >
            <TileLayer
                attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            <Marker position={[51.505, -0.09]} icon={ICON}>
                <Popup>
                A pretty CSS3 popup. <br /> Easily customizable.
                </Popup>
            </Marker>
        </MapContainer>
    </>
  )
}

export default DummyComponent