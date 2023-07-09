import React, { useState } from 'react'
import { ISearchInputs } from './ISearch'
import useAxiosPrivate from '@/hooks/useAxiosPrivate';

const SearchFavourites = (props: ISearchInputs) => {

    const { location } = props;
    const { numbers } = location;

    const axiosPrivate = useAxiosPrivate();

    const [isClicked, setIsClicked] = useState(false);
    const [isSuccess, setIsSuccess] = useState(false);

    const handleClick = async () => {
        setIsClicked(true);
        try {
            const user = localStorage.getItem('user');
            const userObj = JSON.parse(user? user : '');
            const data = {
                latitude: numbers.lat,
                longitude: numbers.lon,
                distance: numbers.radius,
                appUser: userObj
            }
            const response = await axiosPrivate.post('/api/aoi/post', data);
            response.status === 200 && setIsSuccess(true);
        }
        catch(error) {
            console.error(error);
        }
    }

  return (
    <div className='h-[25%] w-[100%]'>
        <div className='mt-14 w-[100%] flex items-center justify-center'>
            {
                !isClicked ?
                <button
                disabled={numbers.radius === 0 && true}
                className={`flex justify-center items-center w-48 h-14 rounded text-white text-base 
                ${numbers.radius === 0 ? 'cursor-not-allowed' : 'cursor-pointer'} 
                ${numbers.radius === 0 ? 'bg-slate-500' : 'bg-orange-500'} 
                ${numbers.radius === 0 ? 'hover:bg-slate-500' : 'hover:bg-orange-400'}`}
                onClick={handleClick}
                >
                    Αποθήκευση της αναζήτησης
                </button> :
                isSuccess ?
                <p className='text-lg text-center w-[90%] text-green-500 font-medium'>
                    Η αναζήτηση αποθηκεύτηκε με επιτυχία
                </p> :
                <p className='text-lg text-center w-[90%] text-red-500 font-medium'>
                    Προέκυψε σφάλμα
                </p>
            }
        </div>
    </div>
  )
}

export default SearchFavourites