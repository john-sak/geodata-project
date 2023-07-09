import React, {useState} from 'react'
import { ISearchFreeTextInputProps } from './ISearch'
import SearchIcon from '@mui/icons-material/Search';
import CloseIcon from '@mui/icons-material/Close';
import useCloseModal from '@/hooks/useCloseModal';

const SearchSideFreeText = (props: ISearchFreeTextInputProps) => {

    const {
        data,
        value,
        name,
        label
    } = props;

    const { handleInputChange } = data;

    const [isFocused, setIsFocused] = useState(false);
    const [clicked, setClicked] = useState(false);

    const handleInputFocus = () => {
        setIsFocused(true);
    };

    const handleInputBlur = () => {
        setIsFocused(false);
    };

    let ref = useCloseModal(() => {
      setClicked(false);
  })

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
                className='w-[85%] rounded-l-md outline-none text-ellipsis whitespace-nowrap overflow-hidden'
                type="text"
                value={value}
                onChange={(e) => handleInputChange(name, e.target.value)}
                onFocus={handleInputFocus}
                onBlur={handleInputBlur}
                />
                <div className='w-[15%] h-[100%] flex items-center justify-center'>
                    <i className='text-sky-500'>
                    {
                        value.length !== 0 ?
                        <CloseIcon
                        fontSize='large'
                        onClick={() => handleInputChange(name, '')}
                        className='cursor-pointer'
                        /> :
                        <SearchIcon
                        fontSize='large'
                        />
                    }
                    </i>
                </div>
            </div>
        </div>
        
        
    </div>
  )
}

export default SearchSideFreeText