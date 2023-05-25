import React, { useState } from 'react'
import { ISearchFilter } from './ISearch'
import SearchIcon from '@mui/icons-material/Search';
import useCloseModal from '@/hooks/useCloseModal';

const SearchSide = (props: ISearchFilter) => {

    const { open, value, setValue } = props;

    const [clicked, setClicked] = useState(false);

    let ref = useCloseModal(() => {
        setClicked(false);
    })

  return (
    <>
        {
            open &&
            <div className='h-[100%] w-[100%] bg-red-500 flex flex-col lg:w-[20%]'>
                <div className='w-[100%] h-[100%] flex flex-col mt-16 lg:mt-0'>
                    <div className='w-[100%] h-[25%] bg-green-600 z-0'>
                        <div className='w-[100%] h-10 mt-4 bg-amber-500 flex items-center justify-start'>
                            <p className='text-lg ml-4'>
                                Τύπος Κτιρίου
                            </p>
                        </div>
                        <div ref={ref}>
                            <div className='h-[55px] w-[92%] bg-pink-300 ml-4 mt-8 rounded flex flex-row'>
                                <input 
                                className='w-[85%] rounded-l-lg'
                                type="text"
                                value={value}
                                onChange={(e) => setValue(e.target.value)}
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
                    <div className='w-[100%] h-[25%] bg-green-600'>

                    </div>
                    <div className='w-[100%] h-[25%] bg-green-600'>

                    </div>
                    <div className='w-[100%] h-[25%] bg-green-600'>

                    </div>
                </div>
                
            </div>
        }
    </>
    
  )
}

export default SearchSide