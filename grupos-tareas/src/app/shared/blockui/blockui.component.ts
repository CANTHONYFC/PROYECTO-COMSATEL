import { MessageService } from 'primeng/api';
import { BaseComponent } from './../../utilities/clases/BaseComponent';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blockui',
  templateUrl: './blockui.component.html',
  styleUrls: ['./blockui.component.scss']
})
export class BlockuiComponent extends BaseComponent implements OnInit {

  constructor(messageService:MessageService) { 
    super(messageService)
  }

  ngOnInit(): void {
  }

}
