import React, { useState } from 'react'
import { ISearchInputProps } from './ISearch'
import useCloseModal from '@/hooks/useCloseModal';
import SearchIcon from '@mui/icons-material/Search';

const SearchInput = (props: ISearchInputProps) => {

    const {
        data,
        value,
        name,
        label
    } = props;

    const { handleInputChange } = data;

    const [clicked, setClicked] = useState(false);

    let ref = useCloseModal(() => {
        setClicked(false);
    })

  return (
    <div className='w-[100%] h-[25%] bg-green-600 z-0'>
        <div className='w-[100%] h-10 mt-4 bg-amber-500 flex items-center justify-start'>
            <p className='text-lg ml-4'>
                {label}
            </p>
        </div>
        <div ref={ref}>
            <div className='h-[55px] w-[94%] bg-pink-300 ml-4 mt-8 rounded flex flex-row lg:w-[90%]'>
                <input 
                className='w-[85%] rounded-l-lg'
                type="text"
                value={value}
                onChange={(e) => handleInputChange(name, e.target.value)}
                />
                <div className='w-[15%] h-[100%] flex items-center justify-center'>
                    <i className='text-sky-500'>
                        <SearchIcon
                        fontSize='large'
                        onClick={() => setClicked(!clicked)}
                        />
                    </i>
                </div>
            </div>
            {
                clicked &&
                    <div className='h-[150px] w-[92%] bg-white ml-4 z-10 rounded-b-lg'>

                    </div>
            }
        </div>
        
        
    </div>
  )
}

export default SearchInput