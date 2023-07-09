import React, { useState } from 'react'
import { CircularProgressbar, buildStyles } from 'react-circular-progressbar';
import 'react-circular-progressbar/dist/styles.css';
import Slider from '@mui/material/Slider';
import { ISearchPoi } from './ISearch';

const SearchRadius = (props: ISearchPoi) => {

  const { numbers, setNumbers, selectedName } = props;

  const handleChange = (event: any, newValue: number | number[]) => {
    setNumbers('radius', newValue as number)
  };

  return (
    <div className='relative w-[100%] h-[25%] bg-sky-800 flex flex-col items-center justify-center'>
        <div className='w-[100%] mt-4 flex items-center justify-start'>
            <p className='text-lg ml-4'>
                Ακτίνα
            </p>
        </div>
        <div style={{ width: 150, height: 150 }}>
            <CircularProgressbar
                value={numbers.radius}
                maxValue={5}
                text={`${numbers.radius} km`}
                circleRatio={0.75}
                styles={buildStyles({
                rotation: 1 / 2 + 1 / 8,
                strokeLinecap: "butt",
                trailColor: "#eee",
                pathColor: "#FDBA74",
                textColor: "#eee"
                })}
            />
      </div>
      <div className='mt-[-20px] w-[60%] flex items-center justify-center flex-col'>
        <Slider
            value={numbers.radius}
            min={0}
            max={5}
            step={1}
            onChange={handleChange}
            aria-labelledby="slider-label"
            style={{
            color: selectedName === '-' ? '#eee' : '#FDBA74',
            }}
            disabled={selectedName === '-' && true}
        />
      </div>
    </div>
  )
}

export default SearchRadius