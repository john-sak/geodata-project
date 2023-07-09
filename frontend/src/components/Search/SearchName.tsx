import React from 'react'
import PlaceIcon from '@mui/icons-material/Place';
import { ISearchPoi } from './ISearch';

const SearchName = (props: ISearchPoi) => {

    const { selectedName } = props;

  return (
    <div className='relative w-[100%] h-[18%] bg-sky-800 flex flex-col'>
        <div className='w-[100%] h-10 mt-4 flex items-center justify-start flex-row'>
            <p className='text-lg ml-4'>
                Ενδιαφέρον
            </p>
            <i className='text-white absolute right-5'>
                <PlaceIcon fontSize='large'/>
            </i>
        </div>
        <div className='w-[100%] h-7 mt-4 flex items-center justify-center'>
            <p className='max-w-[280px] h-7 text-white text-lg text-center break-words overflow-hidden whitespace-nowrap text-ellipsis'>
                {selectedName}
            </p>
        </div>
    </div>
  )
}

export default SearchName