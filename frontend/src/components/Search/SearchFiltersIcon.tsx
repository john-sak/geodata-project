import React from 'react'
import TuneIcon from '@mui/icons-material/Tune';
import { ISearchFilter } from './ISearch';

const SearchFiltersIcon = (props: ISearchFilter) => {
    
    const { open, setOpen } = props;

  return (
    <div className='absolute h-16 w-[100%] flex justify-start items-center lg:hidden'>
        <i>
            <TuneIcon
            fontSize='large'
            className='ml-4 cursor-pointer'
            onClick={() => setOpen(!open)}
            />
        </i>
    </div>
  )
}

export default SearchFiltersIcon