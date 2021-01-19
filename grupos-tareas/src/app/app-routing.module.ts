
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppMainComponent } from './app.main.component';
import { AppComunLoginComponent } from './core/comun-login/app.comun-login.component';
import { ButtonDemoComponent } from './demo/view/buttondemo.component';
import { ChartsDemoComponent } from './demo/view/chartsdemo.component';
import { DashboardDemoComponent } from './demo/view/dashboarddemo.component';
import { DocumentationComponent } from './demo/view/documentation.component';
import { EmptyDemoComponent } from './demo/view/emptydemo.component';
import { FileDemoComponent } from './demo/view/filedemo.component';
import { FormLayoutDemoComponent } from './demo/view/formlayoutdemo.component';
import { InputDemoComponent } from './demo/view/inputdemo.component';
import { ListDemoComponent } from './demo/view/listdemo.component';
import { MediaDemoComponent } from './demo/view/mediademo.component';
import { MenusDemoComponent } from './demo/view/menusdemo.component';
import { MessagesDemoComponent } from './demo/view/messagesdemo.component';
import { MiscDemoComponent } from './demo/view/miscdemo.component';
import { OverlaysDemoComponent } from './demo/view/overlaysdemo.component';
import { PanelsDemoComponent } from './demo/view/panelsdemo.component';
import { TableDemoComponent } from './demo/view/tabledemo.component';
import { TreeDemoComponent } from './demo/view/treedemo.component';
 import { AppCalendarComponent } from './pages/app.calendar.component';
import { AppCrudComponent } from './pages/app.crud.component';
import { AppHelpComponent } from './pages/app.help.component';
import { AppInvoiceComponent } from './pages/app.invoice.component';
import { AppNotfoundComponent } from './pages/app.notfound.component';
import { DisplayComponent } from './utilities/display.component';
import { ElevationComponent } from './utilities/elevation.component';
import { FlexboxComponent } from './utilities/flexbox.component';
import { GridComponent } from './utilities/grid.component';
import { IconsComponent } from './utilities/icons.component';
import { SpacingComponent } from './utilities/spacing.component';
import { TextComponent } from './utilities/text.component';
import { TypographyComponent } from './utilities/typography.component';
import { WidgetsComponent } from './utilities/widgets.component';
import { DisenoCarritoComponent } from './modulos/alertas/disenopresentacion/diseno-carrito/diseno-carrito.component';



@NgModule({
    imports: [
        RouterModule.forRoot([
        
            { path: 'logincore', component: AppComunLoginComponent },
            
            {
                path: '', component: AppMainComponent,
                children: [

                    { path: 'diseno-carrito', component: DisenoCarritoComponent },

                     

                ]
            },

            {
                path: 'demo', component: AppMainComponent,
                children: [
                    { path: '', component: DashboardDemoComponent },
                    { path: 'uikit/formlayout', component: FormLayoutDemoComponent },
                    { path: 'uikit/input', component: InputDemoComponent },
                    { path: 'uikit/button', component: ButtonDemoComponent },
                    { path: 'uikit/table', component: TableDemoComponent },
                    { path: 'uikit/list', component: ListDemoComponent },
                    { path: 'uikit/tree', component: TreeDemoComponent },
                    { path: 'uikit/panel', component: PanelsDemoComponent },
                    { path: 'uikit/overlay', component: OverlaysDemoComponent },
                    { path: 'uikit/menu', component: MenusDemoComponent },
                    { path: 'uikit/media', component: MediaDemoComponent },
                    { path: 'uikit/message', component: MessagesDemoComponent },
                    { path: 'uikit/misc', component: MiscDemoComponent },
                    { path: 'uikit/charts', component: ChartsDemoComponent },
                    { path: 'uikit/file', component: FileDemoComponent },
                    { path: 'utilities/display', component: DisplayComponent },
                    { path: 'utilities/elevation', component: ElevationComponent },
                    { path: 'utilities/flexbox', component: FlexboxComponent },
                    { path: 'utilities/grid', component: GridComponent },
                    { path: 'utilities/icons', component: IconsComponent },
                    { path: 'utilities/widgets', component: WidgetsComponent },
                    { path: 'utilities/spacing', component: SpacingComponent },
                    { path: 'utilities/typography', component: TypographyComponent },
                    { path: 'utilities/text', component: TextComponent },
                    { path: 'pages/crud', component: AppCrudComponent },
                    { path: 'pages/calendar', component: AppCalendarComponent },
                    { path: 'pages/invoice', component: AppInvoiceComponent },
                    { path: 'pages/help', component: AppHelpComponent },
                    { path: 'pages/empty', component: EmptyDemoComponent },
                    { path: 'documentation', component: DocumentationComponent }
                ]
            },
            { path: '**', component: AppNotfoundComponent },
        ], { scrollPositionRestoration: 'enabled' })
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
