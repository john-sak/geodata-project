import React, { useState, useRef, useEffect, ChangeEvent, MouseEventHandler } from 'react'
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
        // setClicked(false);

        if(value.length !== 0) {
            const substrings = value.split(',');
            const validSubstrings = substrings.filter(substring => {
                const trimmedSubstring = substring.trim();
                return dummyData.some(option => option.name.toLowerCase() === trimmedSubstring.toLowerCase());
            });
            const updatedValue = validSubstrings.join(',');
            if(updatedValue.length !== 0) {
                handleInputChange(name, updatedValue + ',');
            }
            else {
                handleInputChange(name, '');
            }
        }
        

        setFilteredData([]);
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

    const [filteredData, setFilteredData] = useState<any>([]);

    // const [userInput, setUserInput] = useState('');
    const [selectedOptions, setSelectedOptions] = useState<string[]>([]);

    const handleFilter = (e: ChangeEvent<HTMLInputElement>) => {
        const parts = e.target.value.split(',');
        const inputValue = parts[parts.length - 1].trim();
        const filteredInput = dummyData.filter((value) => {
            return value.name.toLowerCase().includes(inputValue.toLowerCase());
        })
        const isSpaceOrSequenceOfSpaces = /^\s*$/.test(inputValue);
        if(isSpaceOrSequenceOfSpaces) {
            setFilteredData([]);
        }
        else {
            const inputAscending = [...filteredInput].sort((a, b) => {
                return a.name > b.name ? 1 : -1
            });
            setFilteredData(inputAscending.slice(0, 4));
        }
        handleInputChange(name, e.target.value);
        // setUserInput(e.target.value);
    }

    const handleSelect = (str: string) => {
        const isAlreadySelected = selectedOptions.some(selectedOption => selectedOption === str);
        if(!isAlreadySelected) {
            // const optionName = str + ',';
            // setUserInput(prevValue => prevValue + optionName);
            setSelectedOptions(prevOptions => [...prevOptions, str]);
        }
    }

    useEffect(() => { 
        selectedOptions.length !==0 && handleInputChange(name, selectedOptions.join(',') + ',');
        setFilteredData([]);
    }, [selectedOptions])

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
                onChange={handleFilter}
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
                filteredData.length !==0 &&
                    <div className='absolute min-h-0 max-h-[160px] w-[92%] bg-white ml-4 z-10 rounded-b-md lg:w-[88%] xl:w-[90%]'>
                        {
                            dummyData.map((value) => {
                                return(
                                    <p
                                    key={value.id}
                                    onClick={() => handleSelect(value.name)}
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