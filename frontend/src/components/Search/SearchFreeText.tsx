import React from 'react'
import SearchIcon from '@mui/icons-material/Search';
import { ISearchInputProps } from './ISearch'

const SearchFreeText = (props: ISearchInputProps) => {

    const {
        data,
        value,
        name
    } = props;

    const { handleInputChange } = data;

  return (
    <div
    className='hidden lg:absolute lg:right-12 lg:top-6 lg:flex border-2 border-orange-300 rounded'
    >
        <div
        className='h-12 w-[60vw] bg-white rounded flex flex-row xl:w-[40vw] 2xl:w-[30vw]'
        >
            <input
            className='w-[85%] rounded-l-lg placeholder:text-slate-400 py-2 pl-3 pr-3' 
            type="text" 
            value={value}
            onChange={(e) => handleInputChange(name, e.target.value)}
            placeholder="Αναζήτηση στο χάρτη.."
            />
            <div className='w-[15%] h-[100%] flex items-center justify-center'>
                    <i className='text-sky-500'>
                        <SearchIcon
                        fontSize='large'
                        />
                    </i>
                </div>
        </div>
    </div>
  )
}

export default SearchFreeText