import React from 'react'
import PlaceIcon from '@mui/icons-material/Place';

const SearchName = () => {
  return (
    <div className='relative w-[100%] h-[15%] bg-sky-800 flex flex-col'>
        <div className='w-[100%] h-10 mt-4 flex items-center justify-start flex-row'>
            <p className='text-lg ml-4'>
                Ενδιαφέρον
            </p>
            <i className='text-white absolute right-5'>
                <PlaceIcon fontSize='large'/>
            </i>
        </div>
        <div className='w-[100%] h-7 mt-4 flex items-center justify-center'>
            <p className='w-[90%] h-7 text-white text-lg text-center break-words overflow-hidden whitespace-nowrap text-ellipsis'>
                -
            </p>
        </div>
    </div>
  )
}

export default SearchName