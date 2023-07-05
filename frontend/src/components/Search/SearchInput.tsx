import React, { useState, useRef, useEffect } from 'react'
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

    const inputRef = useRef<HTMLInputElement | null>(null);
    const [isFocused, setIsFocused] = useState(false);

    const handleInputFocus = () => {
        setIsFocused(true);
    };

    const handleInputBlur = () => {
        setIsFocused(false);
    };

    const dummyData: {id: number, name: string}[] = [
        {
            id: 1,
            name: 'Επιλογή1'
        },
        {
            id: 2,
            name: 'Επιλογή2'
        },
        {
            id: 3,
            name: 'Επιλογή3'
        },
        {
            id: 4,
            name: 'Επιλογή4'
        },
    ];

  return (
    <div className='relative w-[100%] h-[17%] bg-sky-800'>
        <div className='w-[100%] mt-4 flex items-center justify-start'>
            <p className='text-lg ml-4'>
                {label}
            </p>
        </div>
        <div ref={ref}>
            <div 
            className={`h-12 w-[92%] bg-white border-2 ${isFocused ? 'border-orange-300' : 'border-transparent'}
             ml-4 mt-6 ${clicked ? 'rounded-t-md' : 'rounded-md'} flex flex-row py-2 pl-2 pr-2 lg:w-[88%] xl:w-[90%]`}
             >
                <input 
                className='w-[85%] rounded-l-md outline-none'
                type="text"
                value={value}
                onChange={(e) => handleInputChange(name, e.target.value)}
                ref={inputRef}
                onFocus={handleInputFocus}
                onBlur={handleInputBlur}
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
                    <div className='absolute min-h-0 max-h-[160px] w-[92%] bg-white ml-4 z-10 rounded-b-md lg:w-[88%] xl:w-[90%]'>
                        {
                            dummyData.map((value) => {
                                return(
                                    <p
                                    key={value.id}
                                    className='h-10 flex items-center justify-start pl-2 text-base hover:bg-sky-100 hover:cursor-pointer last:rounded-b-md'
                                    >
                                        {value.name}
                                    </p>
                                )
                            })
                        }
                    </div>
            }
        </div>
        
        
    </div>
  )
}

export default SearchInput